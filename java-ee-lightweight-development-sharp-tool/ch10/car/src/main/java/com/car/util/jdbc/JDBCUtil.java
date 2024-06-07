package com.car.util.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * jdbc util.
 */
public final class JDBCUtil {
    private JDBCUtil() {
    }

    private static Logger log = LoggerFactory.getLogger(JDBCUtil.class);
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    /**
     * 根据properties文件路径获取输入流.
     *
     * @param propertiesPath <br/>
     *                       driver = <br/>
     *                       url = <br/>
     *                       username = <br/>
     *                       password = <br/>
     * @return input stream
     */
    public static InputStream getPropertiesInputStream(String propertiesPath) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesPath);
    }

    /**
     * 初始化参数.
     *
     * @param inStream stream
     */
    public static void initPorperties(InputStream inStream) {
        try {
            Properties p = new Properties();
            p.load(inStream);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            Class.forName(driver); //装载驱动
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 参数赋值.
     *
     * @param ps   prepared statement
     * @param vals values
     * @throws SQLException sql exception
     */
    public static void setPSObject(PreparedStatement ps, Object[] vals) throws SQLException {
        if (vals != null && vals.length > 0) {
            for (int i = 0; i < vals.length; i++) {
                ps.setObject(i + 1, vals[i]);
            }
        }
    }

    /**
     * 获取连接.
     *
     * @return connection
     * @throws Exception exception
     */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 释放资源.
     *
     * @param rs   result set
     * @param conn connection
     * @param ps   prepared statement
     */
    public static void free(ResultSet rs, Connection conn, PreparedStatement ps) {
        freeResultSet(rs);
        freeStatement(ps);
        freeConnection(conn);
    }

    /**
     * 释放连接.
     *
     * @param conn connection
     */
    public static void freeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("关闭JDBC连接出错", e);
        }
    }

    /**
     * 释放结果集.
     *
     * @param rs result set
     */
    public static void freeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            log.error("关闭JDBC连接出错", e);
        }
    }

    /**
     * 释放PS.
     *
     * @param ps statement
     */
    public static void freeStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            log.error("关闭JDBC.Statement出错", e);
        }
    }

}
