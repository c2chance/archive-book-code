package com.manage.platform.dao.impl;



import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author wangbo
 * @despcription 持久层类
 */
public class DaoImplBaseExpand {
	protected JdbcTemplate jdbcTemplate;
	protected NamedParameterJdbcTemplate namedjdbcTemplate;
	//protected static final Logger logger = LoggerFactory.getLogger("interfaceLogger");
	protected Logger log4j = Logger.getLogger(DaoImplBaseExpand.class);

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
	
	public StringBuffer pageSql(StringBuffer sql_in,int start, int count) {		
			StringBuffer sql = new StringBuffer();
			sql.append(" select * from (");
			sql.append("     select * from (");
			sql.append(sql_in);
			sql.append("                ) p ");
			sql.append("          where p.row_number >= " + start + ") q ");
			sql.append("  where rownum <= " + count + " ");
			return sql;
	}	
}
