package com.car.util.jdbc.impl;

import com.car.util.bean.BeanUtil;
import com.car.util.jdbc.JDBCUtil;
import com.car.util.jdbc.callback.SQLCallback;
import com.car.util.number.ProgressUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于JDBC查询.<br/>
 * 分页查询：调用SQLHelper.getPageSql(   )获取SQL语句，再调用JDBCQueryHelper.query(   )
 */
@SuppressWarnings("unchecked")
public final class JDBCQueryHelper {
    private static Logger log = LoggerFactory.getLogger(JDBCQueryHelper.class);

    private JDBCQueryHelper() {
    }

    /**
     * 查询SQL并返回结果集.
     *
     * @param sql  SQL语句
     * @param vals SQL语句参数值
     * @return list object
     * @throws SQLException sql exception
     */
    public static List<Object[]> list(String sql, Object vals) throws SQLException {
        return list(Object[].class, sql, vals);
    }

    /**
     * 查询SQL并返回结果集.
     *
     * @param cls  类
     * @param sql  SQL语句
     * @param vals SQL语句参数值
     * @param <T>  class
     * @return clazz object
     * @throws SQLException sql exception
     */
    public static <T> List<T> list(Class<T> cls, String sql, Object... vals) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT); //SUPPRESS
            ps.setFetchSize(10000);  //SUPPRESS
            JDBCUtil.setPSObject(ps, vals);
            rs = ps.executeQuery();

            list = new ArrayList<T>();
            while (rs.next()) {
                list.add(setT(cls, rs));
            }
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            e.printStackTrace();
            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(rs, conn, ps);
        }
        return list;
    }

    /**
     * 查询SQL并调用回调方法进行处理数据.
     *
     * @param sql         SQL语句
     * @param sqlCallback 泛型回调方法，用于处理返回的数据，需指定泛型类型
     * @param <T>         call back class
     * @throws SQLException sql exception
     */
    public static <T> void listWithCallback(String sql, SQLCallback<T> sqlCallback) throws SQLException {
        listWithCallback(sql, null, sqlCallback);
    }

    /**
     * 查询SQL并调用回调方法进行处理数据.
     *
     * @param sql         SQL语句
     * @param vals        SQL语句参数值
     * @param sqlCallback 泛型回调方法，用于处理返回的数据，需指定泛型类型
     * @param <T>         clazz
     * @throws SQLException sql exception
     */
    public static <T> void listWithCallback(String sql, Object[] vals, SQLCallback<T> sqlCallback) throws SQLException {
        Connection conn = null;
        PreparedStatement countps = null;
        PreparedStatement ps = null;
        ResultSet countrs = null;
        ResultSet rs = null;
        int max = 10000; //SUPPRESS
        double counts = 0;
        try {

            List<T> list = new ArrayList<T>();
            //获取泛型类型
            Type type = sqlCallback.getClass().getGenericInterfaces()[0];
            Class<T> cls = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];

            String countSql = "select count(*) from " + sql.toLowerCase().split("from")[1];
            log.info("JDBC查询:" + countSql);
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);

            countps = conn.prepareStatement(countSql);
            JDBCUtil.setPSObject(countps, vals);
            long countlong = System.currentTimeMillis();
            countrs = countps.executeQuery();
            if (countrs.next()) {
                counts = countrs.getDouble(1);
            }
            log.info("COUNT:" + counts + "，耗时" + (float) (System.currentTimeMillis() - countlong) / 1000 + "秒JDBC查询:" + countSql); //SUPPRESS

            log.info("JDBC查询:" + sql);
            ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT); //SUPPRESS
            ps.setFetchSize(max);
            JDBCUtil.setPSObject(ps, vals);
            long qlong = System.currentTimeMillis();
            rs = ps.executeQuery();
            log.info("耗时" + (float) (System.currentTimeMillis() - qlong) / 1000 + "秒JDBC查询:" + sql); //SUPPRESS

            //字段
            int columncount = rs.getMetaData().getColumnCount();
            String[] fields = new String[columncount];
            for (int i = 0; i < columncount; i++) {
                fields[i] = rs.getMetaData().getColumnLabel(i + 1);
            }
            sqlCallback.setFields(fields);

            long opstart = System.currentTimeMillis();
            long start = System.currentTimeMillis();
            double cur = 0;

            while (rs.next()) {
                list.add(setT(cls, rs));

                if (list.size() == max) {//一个批次回调方法
                    float s1 = (float) (System.currentTimeMillis() - start) / 1000; //SUPPRESS
                    long s2 = System.currentTimeMillis();
                    sqlCallback.run(list);
                    float scb = (float) (System.currentTimeMillis() - s2) / 1000; //SUPPRESS
                    log.info(ProgressUtil.progress(cur, counts) + "获取" + list.size() +
                            "条数据耗时" + s1 + "秒，处理" + list.size() + "条数据耗时" + scb + "秒");
                    list.clear();
                    start = System.currentTimeMillis();
                }
                cur++;
            }

            if (list.size() > 0) {//最后一个批次回调方法
                float s1 = (float) (System.currentTimeMillis() - start) / 1000; //SUPPRESS
                long s2 = System.currentTimeMillis();
                sqlCallback.run(list);
                float scb = (float) (System.currentTimeMillis() - s2) / 1000; //SUPPRESS
                log.info(ProgressUtil.progress(cur, counts) + "获取" + list.size() + "条数据耗时" + s1 + "秒，处理" +
                        list.size() + "条数据耗时" + scb + "秒");
                list.clear();
                start = System.currentTimeMillis();
            }

            log.info("处理" + cur + "条数据耗时" + (float) (System.currentTimeMillis() - opstart) / 1000 + "秒"); //SUPPRESS
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            e.printStackTrace();
            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(countrs, null, countps);
            JDBCUtil.free(rs, conn, ps);
        }
    }

    /**
     * 返回单个结果集，如count|min|max等.
     *
     * @param sql  sql
     * @param vals values
     * @return object
     * @throws SQLException sql exception
     */
    public static Object uniqueResult(String sql, Object vals) throws SQLException {
        return uniqueResult(null, sql, vals);
    }

    /**
     * 查询单个结果集.
     *
     * @param cls  clazz
     * @param sql  sql
     * @param vals values
     * @param <T>  class type
     * @return class object
     * @throws SQLException sql exception
     */
    public static <T> T uniqueResult(Class<T> cls, String sql, Object... vals) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object o = null;
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            JDBCUtil.setPSObject(ps, vals);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (cls != null) {
                    o = setT(cls, rs);
                } else {
                    o = rs.getObject(1);
                }
            }

            if (rs.next()) {
                rs.last(); //移到最后一行
                throw new Exception("query did not return a unique result:" + rs.getRow());
            }

            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }

            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(rs, conn, ps);
        }
        return (T) o;
    }

    /**
     * 设置返回对象.
     *
     * @param cls 类
     * @param rs  返回对象
     * @param <T> class type
     * @return class object
     * @throws Exception exception
     */
    public static <T> T setT(Class<T> cls, ResultSet rs) throws Exception {
        int count = rs.getMetaData().getColumnCount();
        T o = BeanUtil.newInstance(cls, count);
        for (int i = 0; i < count; i++) {
            //获取值
            String colsName = rs.getMetaData().getColumnName(i + 1);
            Object colsValue = rs.getObject(colsName);
            BeanUtil.setT(o, colsName, colsValue, i);
        }
        return o;
    }

}
