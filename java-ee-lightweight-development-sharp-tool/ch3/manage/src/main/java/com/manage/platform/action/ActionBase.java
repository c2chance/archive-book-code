package com.manage.platform.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionBase {
	protected static final Logger logger = LoggerFactory
			.getLogger("interfaceLogger");

	// Spring配置或者Action传入传出时使用，需要实现get，set
	protected String page;
	protected String rows;
	protected Map dataMap = new HashMap();
	protected String condition;
	protected String maindatauuid;
	protected String maindata;
	protected JSONArray jsonarr;
	protected String exportflag;
//测试
	/*
	 * 另外，下面两个对外的属性可以取消掉， 因为有的时候返回格式比这个复杂（比如保存成功的时候，要返回成功的条数还有新增数据的主键），
	 * 不方便扩展，返回都直接用dataMap
	 */
	// private int returncount;
	// private String maindatajsonstr;
	
	public String getExportflag() {
		return exportflag;
	}

	public void setExportflag(String exportflag) {
		this.exportflag = exportflag;
	}
	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @return the rows
	 */
	public String getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            the rows to set
	 */
	public void setRows(String rows) {
		this.rows = rows;
	}

	/**
	 * @return the dataMap
	 */
	public Map getDataMap() {
		return dataMap;
	}

	/**
	 * @param dataMap
	 *            the dataMap to set
	 */
	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the maindatauuid
	 */
	public String getMaindatauuid() {
		return maindatauuid;
	}

	/**
	 * @param maindatauuid
	 *            the maindatauuid to set
	 */
	public void setMaindatauuid(String maindatauuid) {
		this.maindatauuid = maindatauuid;
	}

	public String getMaindata() {
		return maindata;
	}

	public void setMaindata(String maindata) {
		this.maindata = maindata;
	}

	public JSONArray getJsonarr() {
		return jsonarr;
	}

	public void setJsonarr(JSONArray jsonarr) {
		this.jsonarr = jsonarr;
	}


}
