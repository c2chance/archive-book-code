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
	// ����
	private static String dbDriver = "com.mysql.jdbc.Driver";
	// ���ݿ�
	private static String url = "jdbc:mysql://localhost:3306/chapter4?useUnicode=true&characterEncoding=UTF8";
	// ��¼���ݿ���û���
	private static String usr = "root";
	// ��¼���ݿ������
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
	
	
	/*�������ݿⲽ��
	 * 1. ��ȡConnection����
	 * 2. ��ȡStatement��������ִ��SQL���
	 * 3. ��״̬����ִ��SQL��䣬���ؽ����ResultSet
	 * 4. ���ιر�ResultSet����Statement״̬����Connection���Ӷ���
	 */
	// ��ȡConnection����
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// ��������
			Class.forName(dbDriver);
			// ��ȡ����
			conn = DriverManager.getConnection(url, usr, pwd);
			System.out.println("���ӳɹ�");
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
		return null;
	}
	// ��ȡ����Statement
	public static Statement getStatement(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	// ��ȡPreparedStatement����
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	// ִ��SQL���
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
	// ִ��SQL���
	public static ResultSet getResultSet(PreparedStatement pstmt) {
		ResultSet rt = null;
		try {
			rt = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rt;
	}
	// ���ιر�ResultSet����Statement״̬����Connection���Ӷ���
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
		    *//** ����Statement����  *//*  
		    Statement stmt = conn.createStatement(); 
		    *//** ����PreparedStatement����  *//* 
		    PreparedStatement pstmt = null; 
		    *//** ��������  *//*  
		    String addRecord = "INSERT INTO users(id,name,age)" + 
		          "VALUES(?,?,?)"; 
		    *//** ����Ԥ����������PreparedStatement  *//*  
		    String uuid = UUID.randomUUID().toString().replaceAll("-","");  
		    pstmt = conn.prepareStatement(addRecord); 
		    pstmt.setString(1, uuid); 
		    pstmt.setString(2, "����"); 
		    pstmt.setString(3, "23"); 
		    pstmt.executeUpdate(); 
		  } catch (SQLException e) { 
		    e.printStackTrace(); 
		  } 
		} */

	
/*	public static void main(String[] args) { 
		  Connection conn =  getConnection(); 
		  // ����Statement����
		  try { 
		    Statement stmt = conn.createStatement(); 
		    // ��������
		    String addRecord = "insert into users(id,name,age)" + 
		          "values('33','����','20')"; 
		    stmt.executeUpdate(addRecord); 
		    // ��������
		    String updRecord = "update users set name='��Ī' where name = '����'"; 
		    stmt.executeUpdate(updRecord); 
		    // ɾ������  
		    String delRecord = "delete from users where id = '33'"; 
		    stmt.executeUpdate(delRecord); 
		  } catch (SQLException e) { 
		    e.printStackTrace(); 
		  } 
		}*/
	
/*	public static void main(String[] args) { 
		  Connection conn =  getConnection(); 
		  // ����Statement����   
		  try { 
		    Statement stmt = conn.createStatement(); 
		    // ��ѯ���� 
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

