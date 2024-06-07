package com.javaee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class ConnectionUtil {
	// 驱动
	private static String dbDriver = "com.mysql.jdbc.Driver";
	// 数据库
	private static String url = "jdbc:mysql://localhost:3306/chapter4?useUnicode=true&characterEncoding=UTF8";
	// 登录数据库的用户名
	private static String usr = "root";
	// 登录数据库的密码
	private static String pwd = "123456";
	
	protected JdbcTemplate jdbcTemplate;
	protected NamedParameterJdbcTemplate namedjdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public NamedParameterJdbcTemplate getNamedjdbcTemplate() {
		return namedjdbcTemplate;
	}
	
	public void setNamedjdbcTemplate(NamedParameterJdbcTemplate namedjdbcTemplate) {
		this.namedjdbcTemplate = namedjdbcTemplate;
	}
	
	
	/*连接数据库步骤
	 * 1. 获取Connection对象
	 * 2. 获取Statement对象用来执行SQL语句
	 * 3. 由状态对象执行SQL语句，返回结果集ResultSet
	 * 4. 依次关闭ResultSet对象、Statement状态对象、Connection连接对象
	 */
	// 获取Connection对象
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// 设置驱动
			Class.forName(dbDriver);
			// 获取连接
			conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("连接成功");
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
		return null;
	}
	// 获取对象Statement
	public static Statement getStatement(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	// 获取PreparedStatement对象
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	// 执行SQL语句
	public static ResultSet getResultSet(Statement stmt, String sql) {
		ResultSet rt = null;
		try {
			rt = stmt.executeQuery(sql);
			// stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rt;
	}
	// 执行SQL语句
	public static ResultSet getResultSet(PreparedStatement pstmt) {
		ResultSet rt = null;
		try {
			rt = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rt;
	}
	// 依次关闭ResultSet对象、Statement状态对象、Connection连接对象
	public static void close(ResultSet rt, Statement stmt, Connection conn) {
		if (null != rt) {
			try {
				rt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rt = null;
			}
		}
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
	public static void close(ResultSet rt, PreparedStatement pstmt, Connection conn) {
		if (null != rt) {
			try {
				rt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rt = null;
			}
		}
		if (null != pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				pstmt = null;
			}
		}
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
/*	public static void main(String[] args) {
		Connection conn = getConnection();
		String sql = "select * from users";
		Statement stmt = getStatement(conn);
		ResultSet rt;
		try {
			rt = stmt.executeQuery(sql);
				try {
					while (rt.next()) {
						System.out.println(rt.getString("name"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}*/
	
/*	public static void main(String[] args) { 
		  Connection conn =  getConnection(); 
		  try { 
		    *//** 创建Statement对象  *//*  
		    Statement stmt = conn.createStatement(); 
		    *//** 创建PreparedStatement对象  *//* 
		    PreparedStatement pstmt = null; 
		    *//** 插入数据  *//*  
		    String addRecord = "INSERT INTO users(id,name,age)" + 
		          "VALUES(?,?,?)"; 
		    *//** 创建预处理语句对象PreparedStatement  *//*  
		    String uuid = UUID.randomUUID().toString().replaceAll("-","");  
		    pstmt = conn.prepareStatement(addRecord); 
		    pstmt.setString(1, uuid); 
		    pstmt.setString(2, "张三"); 
		    pstmt.setString(3, "23"); 
		    pstmt.executeUpdate(); 
		  } catch (SQLException e) { 
		    e.printStackTrace(); 
		  } 
		} */

	
/*	public static void main(String[] args) { 
		  Connection conn =  getConnection(); 
		  // 创建Statement对象
		  try { 
		    Statement stmt = conn.createStatement(); 
		    // 插入数据
		    String addRecord = "insert into users(id,name,age)" + 
		          "values('33','桔子','20')"; 
		    stmt.executeUpdate(addRecord); 
		    // 更新数据
		    String updRecord = "update users set name='提莫' where name = '桔子'"; 
		    stmt.executeUpdate(updRecord); 
		    // 删除数据  
		    String delRecord = "delete from users where id = '33'"; 
		    stmt.executeUpdate(delRecord); 
		  } catch (SQLException e) { 
		    e.printStackTrace(); 
		  } 
		}*/
	
/*	public static void main(String[] args) { 
		  Connection conn =  getConnection(); 
		  // 创建Statement对象   
		  try { 
		    Statement stmt = conn.createStatement(); 
		    // 查询数据 
		    String queryRecord = "select * from users"; 
		    ResultSet rs = stmt.executeQuery(queryRecord); 
		    while(rs.next()){ 
		      String id = rs.getString(1); 
		      String name = rs.getString(2); 
		      String age = rs.getString("age"); 
		      
		      System.out.println(id); 
		      System.out.println(name); 
		      System.out.println(age); 
		    } 
		  } catch (SQLException e) { 
		    e.printStackTrace(); 
		  } 
		} */
	
	
	
	public static void main(String[] args) { 	
	}
	

}

