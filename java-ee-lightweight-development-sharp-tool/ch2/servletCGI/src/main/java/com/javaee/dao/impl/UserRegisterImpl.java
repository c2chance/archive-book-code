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
		/** 插入数据 */
		  Connection conn =  getConnection(); 
		  try { 
		    /** 创建Statement对象  */  
		    Statement stmt = conn.createStatement(); 
		    /** 创建PreparedStatement对象  */ 
		    PreparedStatement pstmt = null; 
		    /** 插入数据  */  
		    String addRecord = "INSERT INTO users(id,name,age)" + 
		          "VALUES(?,?,?)"; 
		    /** 创建预处理语句对象PreparedStatement  */  
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
		  // 插入数据   
		  jdbcTemplate.update("insert into users(id,name,age)" + 
		        "values('33','阿尔托利亚','20')");  
		  jdbcTemplate.update("insert into users(id,name,age)" + 
		        "VALUES(?,?,?)",new Object[] {"44", "莫德雷德", "21" }); 
		
		  // 更新数据  
		  jdbcTemplate.update("update users SET name='诸葛孔明' where name = '阿尔托利亚'"); 
		  jdbcTemplate.update("update users SET name= ? where name = ?",new Object[] {"孔明", "阿尔托利亚"}); 
		 
		  // 删除数据   
		  jdbcTemplate.update("delete from users where name = '诸葛孔明'"); 
		  jdbcTemplate.update("delete from users where name = ?",new Object[] {"诸葛孔明"}); 
		 
		  // 查询数据  
		  List queryRecord = jdbcTemplate.queryForList("select * from users");    
		  Iterator it = queryRecord.iterator();    
		  while(it.hasNext()) {    
		    Map userMap = (Map) it.next();    
		    System.out.println(userMap.get("id"));    
		    System.out.println(userMap.get("name"));    
		    System.out.println(userMap.get("age")); 
		  } 
		  
		  
		  
		  
			 // 插入数据
			 Map parameters = new HashMap();
			 parameters.put("id", "6");
			 parameters.put("name", "吕布");
			 parameters.put("age", "42");
			 namedjdbcTemplate.update("insert into users(id,name,age)"
			 +
			 "values(:id,:name,:age)", parameters);

			// 查询数据
			String sql = "select * from users";
			List list = namedjdbcTemplate.getJdbcOperations().queryForList(sql.toString());
			System.out.println(list.size());
			
			String sqlMap = "select * from users where name = '吕布'";
			Map map = namedjdbcTemplate.getJdbcOperations().queryForMap(sqlMap);
			String userName = (String) map.get("name");
			System.out.println(userName);


		return true;
	}

}
