package com.manage.life.dao.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.manage.life.dao.BaseInformationDao;
import com.manage.platform.dao.impl.DaoImplBase;
import com.manage.platform.entity.CardInssuerDetail;
import com.manage.platform.entity.MANAGE_AREAEntity;
import com.manage.report.dao.IMANAGE_REPORTDao;

public class BaseInformationDaoImpl extends DaoImplBase implements BaseInformationDao {



	public String baseInformationInsert(Map<String, String> baseInformation) {
		// TODO Auto-generated method stub
		

		final String name = baseInformation.get("name"); 
		final String sex = baseInformation.get("sex"); 
		final String birth = baseInformation.get("birth"); 
		final String mobile = baseInformation.get("mobile"); 
		final String communication = baseInformation.get("communication"); 
		final String message = baseInformation.get("message"); 
		final String hobby = baseInformation.get("hobby"); 
		final String remark = baseInformation.get("remark"); 
		final String nationality = baseInformation.get("nationality"); 
		
		System.out.println("ffffffff1234==="+name);
//	
		 String sql = "insert into life_baseinformation(id,name,sex,birth,mobile,communication,message,hobby,remark,nationality)" +
		" VALUES(:id,:name,:sex,:birth,:mobile,:communication,:message,:hobby,:remark,:nationality)";	
//		
//		 jdbcTemplate.update("INSERT INTO life_baseinformation VALUES('"  
//		                   + id + "', '"  
//				           + name + "', '"  
//				           + sex + "', '"  
//				           + birth + "', '"  
//				           + mobile + "', '"  
//				           + communication + "', '"  
//				           + message + "', '"  
//				           + hobby + "', '"  
//				           + remark + "', '"  
//				           + nationality + "')");  
		//SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(namedParameters);
		//return this.namedjdbcTemplate.update(sql, namedParameters);
		//List<Map<String, Object>> list = namedjdbcTemplate.getJdbcOperations().queryForList(sql.toString());
		namedjdbcTemplate.update(sql, baseInformation);
		
//		this.jdbcTemplate.update("INSERT INTO life_baseinformation VALUES(?,?,?,?,?,?,?,?,?,?)",   
//				                    new PreparedStatementSetter() {   
//				                        public void setValues(PreparedStatement ps) throws SQLException {   
//				                            ps.setString(1, id);   
//				                            ps.setString(2, name);  
//				                            ps.setString(3, sex);  
//				                            ps.setString(4, birth);  
//				                            ps.setString(5, mobile);  
//				                            ps.setString(6, communication);  
//				                            ps.setString(7, message);  
//				                            ps.setString(8, hobby);  
//				                            ps.setString(9, remark);  
//				                            ps.setString(10, nationality);  
//				                         }   
//				                     });  
		
		return null;
	}



}
