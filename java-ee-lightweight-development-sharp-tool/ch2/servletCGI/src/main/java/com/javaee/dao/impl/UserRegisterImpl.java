package com.javaee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.javaee.dao.UserRegister;
import com.javaee.util.ConnectionUtil;

public class UserRegisterImpl extends ConnectionUtil implements UserRegister {

	public boolean saveUser(String name,String age) {
		/** �������� */
		  Connection conn =  getConnection(); 
		  try { 
		    /** ����Statement����  */  
		    Statement stmt = conn.createStatement(); 
		    /** ����PreparedStatement����  */ 
		    PreparedStatement pstmt = null; 
		    /** ��������  */  
		    String addRecord = "INSERT INTO users(id,name,age)" + 
		          "VALUES(?,?,?)"; 
		    /** ����Ԥ����������PreparedStatement  */  
		    String uuid = UUID.randomUUID().toString().replaceAll("-","");  
		    pstmt = conn.prepareStatement(addRecord); 
		    pstmt.setString(1, uuid); 
		    pstmt.setString(2, name); 
		    pstmt.setString(3, age); 
		    pstmt.executeUpdate(); 
		  } catch (SQLException e) { 
		    e.printStackTrace(); 
		  } 
		  return true;
	}

	public boolean saveUser2(String name, String age) {
		  // ��������   
		  jdbcTemplate.update("insert into users(id,name,age)" + 
		        "values('33','����������','20')");  
		  jdbcTemplate.update("insert into users(id,name,age)" + 
		        "VALUES(?,?,?)",new Object[] {"44", "Ī���׵�", "21" }); 
		
		  // ��������  
		  jdbcTemplate.update("update users SET name='������' where name = '����������'"); 
		  jdbcTemplate.update("update users SET name= ? where name = ?",new Object[] {"����", "����������"}); 
		 
		  // ɾ������   
		  jdbcTemplate.update("delete from users where name = '������'"); 
		  jdbcTemplate.update("delete from users where name = ?",new Object[] {"������"}); 
		 
		  // ��ѯ����  
		  List queryRecord = jdbcTemplate.queryForList("select * from users");    
		  Iterator it = queryRecord.iterator();    
		  while(it.hasNext()) {    
		    Map userMap = (Map) it.next();    
		    System.out.println(userMap.get("id"));    
		    System.out.println(userMap.get("name"));    
		    System.out.println(userMap.get("age")); 
		  } 
		  
		  
		  
		  
			 // ��������
			 Map parameters = new HashMap();
			 parameters.put("id", "6");
			 parameters.put("name", "����");
			 parameters.put("age", "42");
			 namedjdbcTemplate.update("insert into users(id,name,age)"
			 +
			 "values(:id,:name,:age)", parameters);

			// ��ѯ����
			String sql = "select * from users";
			List list = namedjdbcTemplate.getJdbcOperations().queryForList(sql.toString());
			System.out.println(list.size());
			
			String sqlMap = "select * from users where name = '����'";
			Map map = namedjdbcTemplate.getJdbcOperations().queryForMap(sqlMap);
			String userName = (String) map.get("name");
			System.out.println(userName);


		return true;
	}

}
