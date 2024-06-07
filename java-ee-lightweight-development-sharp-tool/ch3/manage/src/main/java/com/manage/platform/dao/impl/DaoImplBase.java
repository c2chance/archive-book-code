package com.manage.platform.dao.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author wangbo
 * @despcription 持久层类
 */
public class DaoImplBase {
	protected JdbcTemplate jdbcTemplate;
	protected NamedParameterJdbcTemplate namedjdbcTemplate;
	protected static final Logger logger = LoggerFactory.getLogger("interfaceLogger");

	/**
	 * @return the jdbcTemplate
	 */
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	/**
	 * @param jdbcTemplate the jdbcTemplate to set
	 */
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * @return the namedjdbcTemplate
	 */
	
	public NamedParameterJdbcTemplate getNamedjdbcTemplate() {
		return namedjdbcTemplate;
	}
	
	/**
	 * @param namedjdbcTemplate the namedjdbcTemplate to set
	 */
	
	public void setNamedjdbcTemplate(NamedParameterJdbcTemplate namedjdbcTemplate) {
		this.namedjdbcTemplate = namedjdbcTemplate;
	}
	
	// Oracle分页
	public StringBuffer pageSql2(StringBuffer sql_in,int start, int count) {		
			StringBuffer sql = new StringBuffer();
			sql.append(" select * from (");
			sql.append("     select * from (");
			sql.append(sql_in);
			sql.append("                ) p ");
			sql.append("          where p.row_number >= " + start + ") q ");
			sql.append("  where rownum <= " + count + " ");
			return sql;
	}
	
	// MySQL分页
	public StringBuffer pageSql(StringBuffer sql_in,int start, int count) {		
		StringBuffer sql = new StringBuffer();
		sql.append(sql_in);
		sql.append(" limit " + start +"," +count);
		return sql;
}
}
