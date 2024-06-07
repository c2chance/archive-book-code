package com.manage.report.dao.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.manage.platform.dao.IMANAGE_USERDao;
import com.manage.platform.dao.impl.DaoImplBase;
import com.manage.platform.entity.MANAGE_USEREntity;
import com.manage.report.dao.ITestStrutsDao;

public class TestStrutsDaoImpl  extends DaoImplBase implements ITestStrutsDao{

	private String BuildCondition(String condition){		
		StringBuffer sb = new StringBuffer();
					
		if(null!=condition && !condition.isEmpty()){
			JSONObject obj = JSONObject.fromObject(condition);
			
			String tbUsername =obj.containsKey("tbUsername")? obj.getString("tbUsername"):"";
			if(null!=tbUsername && !tbUsername.isEmpty()){
				sb.append(" LOGINNAME like '%"+tbUsername+"%' ");	
			}
		}	
		return sb.toString();
	}
	
	
	public List<Map<String, Object>> findByCondition(String condition) {
		condition = BuildCondition(condition);
		StringBuffer sql = new StringBuffer();
		sql.append("                    select ");
		sql.append("               		MANAGE_USER.*, row_number() OVER(ORDER BY null) AS row_number ");
		sql.append("               		from MANAGE_USER ");
		if (null != condition && condition.length() > 0)
			sql.append("                where " + condition);
		//sql = pageSql(sql, start, count);
		logger.info(sql.toString());
		List<Map<String, Object>> list = namedjdbcTemplate.getJdbcOperations().queryForList(sql.toString());
		return list;
	}


}
