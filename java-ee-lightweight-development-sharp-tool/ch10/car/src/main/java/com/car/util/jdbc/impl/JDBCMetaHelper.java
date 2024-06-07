package com.car.util.jdbc.impl;

import com.alibaba.fastjson.JSONObject;
import com.car.util.jdbc.JDBCUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于获取数据库、数据表等元数据信息.
 */
public final class JDBCMetaHelper {
    private static Logger log = LoggerFactory.getLogger(JDBCMetaHelper.class);

    private JDBCMetaHelper() {
    }

    /**
     * 当前表字段.
     *
     * @param tableName table name
     * @return files
     * @throws SQLException sql exception
     */
    public static String[] fields(String tableName) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<String>();
        try {
            conn = JDBCUtil.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getColumns(null, "%", tableName, "%");
            while (rs.next()) {
                list.add(rs.getString("COLUMN_NAME"));
            }
        } catch (Exception e) {
            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(rs, conn, ps);
        }

        return list.toArray(new String[]{});
    }


    /**
     * 数据库信息.
     *
     * @return json object
     * @throws SQLException sql exception
     */
    public static JSONObject tableInfo() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        JSONObject info = new JSONObject();
        try {
            conn = JDBCUtil.getConnection();
            DatabaseMetaData dbmd = conn.getMetaData();
            info.put("user_name", dbmd.getUserName());
            info.put("system_functions", dbmd.getSystemFunctions());
            info.put("time_date_functions", dbmd.getTimeDateFunctions());
            info.put("string_functions", dbmd.getStringFunctions());
            info.put("schema_term", dbmd.getSchemaTerm());
            info.put("url", dbmd.getURL());
            info.put("is_readonly", dbmd.isReadOnly());
            info.put("database_product_name", dbmd.getDatabaseProductName());
            info.put("database_product_version", dbmd.getDatabaseProductVersion());
            info.put("driver_name", dbmd.getDriverName());
            info.put("driver_version", dbmd.getDriverVersion());
        } catch (Exception e) {
            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(null, conn, ps);
        }
        return info;
    }

    /**
     * 全部表元数据.
     *
     * @param cls 指定返回类型
     * @param <T> class
     * @return list object with cls type
     * @throws SQLException sql exception
     */
    public static <T> List<T> listTables(Class<T> cls) throws SQLException {
        return listTables(cls, null);
    }

    /**
     * 表元数据.
     *
     * @param cls       class
     * @param tableName 為空時查全部表
     * @param <T>       type
     * @return list object
     * @throws SQLException sql exception
     */
    public static <T> List<T> listTables(Class<T> cls, String tableName) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            conn = JDBCUtil.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getTables(conn.getCatalog(), "%", StringUtils.isNotEmpty(tableName) ? tableName : "%", new String[]{"TABLE"}); //SUPPRESS
            list = new ArrayList<T>();
            while (rs.next()) {
                list.add(JDBCQueryHelper.setT(cls, rs));
            }
        } catch (Exception e) {
            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(rs, conn, ps);
        }
        return list;
    }

    /**
     * 列元数据.
     *
     * @param tableNames table names
     * @return json object list
     * @throws SQLException sql exception
     */
    public static List<JSONObject> listColumns(String... tableNames) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet pkrs = null;
        List<JSONObject> list = null;
        try {
            conn = JDBCUtil.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();

            for (String tableName : tableNames) {
                pkrs = metaData.getPrimaryKeys(conn.getCatalog(), null, tableName);
                Map<String, List<JSONObject>> pkMap = new HashMap<String, List<JSONObject>>();
                while (pkrs.next()) {
                    JSONObject o = JDBCQueryHelper.setT(JSONObject.class, pkrs);
                    String key = o.getString("COLUMN_NAME") + tableName;
                    List<JSONObject> olist = pkMap.get(key);
                    if (olist == null) {
                        olist = new ArrayList<JSONObject>();
                    }
                    olist.add(o);
                    pkMap.put(key, olist);
                }

                rs = metaData.getColumns(null, "%", tableName, "%");
                list = new ArrayList<JSONObject>();
                int index = 1;
                while (rs.next()) {
                    JSONObject o = JDBCQueryHelper.setT(JSONObject.class, rs);
                    o.put("COLUMN_INDEX", index++);
                    o.put("COLUMN_PK", pkMap.get(o.getString("COLUMN_NAME") + tableName) != null ? "YES" : "");
                    list.add(o);
                }
            }
        } catch (Exception e) {
            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(rs, conn, ps);
        }
        return list;
    }

    /**
     * 主键元数据.
     *
     * @param cls       指定返回类型
     * @param tableName table name
     * @param <T>       clazz
     * @return list with cls object
     * @throws SQLException sql exception
     */
    public static <T> List<T> listPromaryKeys(Class<T> cls, String tableName) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            conn = JDBCUtil.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getPrimaryKeys(conn.getCatalog(), conn.getSchema(), tableName);
            list = new ArrayList<T>();
            while (rs.next()) {
                list.add(JDBCQueryHelper.setT(cls, rs));
            }
        } catch (Exception e) {
            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(rs, conn, ps);
        }
        return list;
    }

    /**
     * 外键元数据.
     *
     * @param cls       指定返回类型
     * @param tableName table name
     * @param <T>       clazz
     * @return list object with T clazz
     * @throws SQLException sql excpetion
     */
    public static <T> List<T> listImportedKeys(Class<T> cls, String tableName) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;
        try {
            conn = JDBCUtil.getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getImportedKeys(conn.getCatalog(), conn.getSchema(), tableName);
            list = new ArrayList<T>();
            while (rs.next()) {
                list.add(JDBCQueryHelper.setT(cls, rs));
            }
        } catch (Exception e) {
            log.error("JDBC操作出错", e);
            throw new SQLException("JDBC操作出错", e);
        } finally {
            JDBCUtil.free(rs, conn, ps);
        }
        return list;
    }

    /**
     * MYSQL数据类型对应JAVA类型.
     *
     * @return mysql type may
     */
    public static Map<String, JSONObject> mysqlType2Map() {
        Map<String, JSONObject> map = new HashMap<String, JSONObject>();

        JSONObject bit = new JSONObject();
        bit.put("type", "boolean");
        map.put("bit", bit);

        JSONObject binary = new JSONObject();
        binary.put("type", "byte[]");
        map.put("binary", binary);
        map.put("image", binary);
        map.put("udt", binary);
        map.put("varbinary", binary);
        map.put("blob", binary);

        JSONObject smallint = new JSONObject();
        smallint.put("type", "short");

        JSONObject intint = new JSONObject();
        smallint.put("type", "int");
        map.put("int", intint);
        map.put("tinyint", intint);
        map.put("smallint", intint);
        map.put("mediumint", intint);
        map.put("boolean", intint);

        JSONObject bigint = new JSONObject();
        bigint.put("type", "BigInteger");
        bigint.put("class", "java.math.BigInteger");
        map.put("bigint", bigint);

        JSONObject bigintint = new JSONObject();
        bigintint.put("type", "long");
        map.put("bigint", bigintint);
        map.put("integer", bigintint);

        JSONObject floatint = new JSONObject();
        floatint.put("type", "float");
        map.put("float", floatint);

        JSONObject doubleint = new JSONObject();
        doubleint.put("type", "double");
        map.put("double", doubleint);

        JSONObject decimal = new JSONObject();
        decimal.put("type", "BigDecimal");
        decimal.put("class", "java.math.BigDecimal");
        map.put("decimal", decimal);
        map.put("money", decimal);
        map.put("smallmoney", decimal);
        map.put("numeric", decimal);

        JSONObject real = new JSONObject();
        decimal.put("type", "float");
        map.put("real", real);

        JSONObject varchar = new JSONObject();
        varchar.put("type", "String");
        varchar.put("class", "java.lang.String");
        map.put("varchar", varchar);
        map.put("char", varchar);
        map.put("nvarchar", varchar);
        map.put("nchar", varchar);
        map.put("text", varchar);
        map.put("ntext", varchar);
        map.put("uniqueidentifier", varchar);
        map.put("xml", varchar);

        JSONObject date = new JSONObject();
        date.put("type", "Date");
        date.put("class", "java.sql.Date");
        map.put("date", date);
        map.put("year", date);

        JSONObject time = new JSONObject();
        time.put("type", "Time");
        time.put("class", "java.sql.Time");
        map.put("time", time);

        JSONObject datetime = new JSONObject();
        datetime.put("type", "Timestamp");
        datetime.put("class", "java.sql.Timestamp");
        map.put("datetime", datetime);
        map.put("timestamp", datetime);
        map.put("smalldatetime", datetime);
        map.put("datetime2", datetime);

        return map;
    }
}
