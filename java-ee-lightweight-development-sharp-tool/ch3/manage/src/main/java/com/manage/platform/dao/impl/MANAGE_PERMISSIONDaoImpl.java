package com.manage.platform.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.manage.platform.dao.IMANAGE_PERMISSIONDao;
import com.manage.platform.entity.MANAGE_PERMISSIONEntity;

public class MANAGE_PERMISSIONDaoImpl extends DaoImplBase implements IMANAGE_PERMISSIONDao {

	public int insert(MANAGE_PERMISSIONEntity entity) {
		try {
			 String sql = "insert into MANAGE_PERMISSION(ICODE,ROLEICODE,MODELICODE)" +
			 		" VALUES(:ICODE,:ROLEICODE,:MODELICODE)";				
			SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(entity);
			return this.namedjdbcTemplate.update(sql, namedParameters);
		} catch (Exception e) {
			e.getMessage();
		}
		return 0;
	}

	public int update(MANAGE_PERMISSIONEntity entity) {
		StringBuffer  sql = new StringBuffer();
        
        sql.append(" UPDATE MANAGE_PERMISSION SET ");
        sql.append(" ROLEICODE =:ROLEICODE,");
        sql.append(" MODELICODE =:MODELICODE ");
        sql.append(" WHERE ICODE=:ICODE");

		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(entity);
		return this.namedjdbcTemplate.update(sql.toString(), namedParameters);
	}

	private String BuildCondition(String condition){		
		StringBuffer sb = new StringBuffer();
			
		//=========================================================================
		// 按主键查询
		//=========================================================================
		if(null!=condition && !condition.isEmpty()){
			JSONObject obj = JSONObject.fromObject(condition);
			String ICODE =obj.containsKey("ICODE")? obj.getString("ICODE"):"";
			if(null!=ICODE  && ICODE .length()>0){
				sb.append(" ICODE='"+obj.get("ICODE")+"' ");
				return sb.toString();
			}	
		}
				
		//前台页面 摸人加载数据也是 默认触发查询按钮产生的，所以，查询条件肯定是有的了。
		if(null!=condition && !condition.isEmpty()){
			JSONObject obj = JSONObject.fromObject(condition);
			
			String ROLEICODE =obj.containsKey("ROLEICODE")? obj.getString("ROLEICODE"):"";
			if(null!=ROLEICODE && !ROLEICODE.isEmpty()){
				sb.append(" ROLEICODE = '"+ROLEICODE+"' ");	
			}
			
			String MODELICODE =obj.containsKey("MODELICODE")? obj.getString("MODELICODE"):"";
			if(null!=MODELICODE && !MODELICODE.isEmpty()){
				if(sb.length()>0)
					sb.append(" and ");
				sb.append(" MODELICODE = '"+MODELICODE+"' ");	
			}
		}
				
		return sb.toString();
	}
	
	
	public List<Map<String, Object>> findByCondition(String condition,int start, int count) {
		condition = BuildCondition(condition);
		StringBuffer sql = new StringBuffer();
/*		sql.append("                    select ");
		sql.append("               		MANAGE_PERMISSION.*, row_number() OVER(ORDER BY null) AS row_number ");
		sql.append("               		from MANAGE_PERMISSION ");*/
		sql.append("                    select ");
		sql.append("               		* ");
		sql.append("               		from MANAGE_PERMISSION ");
		if (null != condition && condition.length() > 0)
			sql.append("                where " + condition);
		sql = pageSql(sql, start, count);
		logger.info(sql.toString());
		List<Map<String, Object>> list = namedjdbcTemplate.getJdbcOperations().queryForList(sql.toString());
		return list;
	}
	
	public int countByCondition(String condition) {
		condition = BuildCondition(condition);
		StringBuffer sql = new StringBuffer();
		sql.append(" select count(1) from MANAGE_PERMISSION ");
		if (null != condition && condition.length() > 0)
			sql.append(" where " + condition);
		return namedjdbcTemplate.getJdbcOperations().queryForInt(sql.toString());
	}

	public int delete(String uuid) {
		StringBuffer sql = new StringBuffer();

		sql.append(" delete from MANAGE_PERMISSION ");
		sql.append(" where ICODE =:ICODE");

		Map paramMap = new HashMap();
		paramMap.put("ICODE", uuid);
		return namedjdbcTemplate.update(sql.toString(), paramMap);
	}

	public Object deleteByRoleicode(String rOLDICODE) {
		StringBuffer sql = new StringBuffer();

		sql.append(" delete from MANAGE_PERMISSION ");
		sql.append(" where ROLEICODE =:ROLEICODE");

		Map paramMap = new HashMap();
		paramMap.put("ROLEICODE", rOLDICODE);
		return namedjdbcTemplate.update(sql.toString(), paramMap);
	}
}
