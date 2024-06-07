package com.manage.report.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.fore.util.JsonUtil;
import com.fore.util.ReadUrlString;
import com.manage.platform.action.ActionBase;
import com.manage.platform.entity.MANAGE_USEREntity;
import com.manage.platform.service.IMANAGE_USERService;
import com.manage.report.dao.ITestStrutsDao;
import com.opensymphony.xwork2.Action;

public class TestStrutsAction extends ActionBase  implements Action {

	private ITestStrutsDao testStrutsDao;


	public ITestStrutsDao getTestStrutsDao() {
		return testStrutsDao;
	}

	public void setTestStrutsDao(ITestStrutsDao testStrutsDao) {
		this.testStrutsDao = testStrutsDao;
	}

	public String execute() throws Exception {
		return null;
	}
	
	/**
	 * 查询和分页功能
	 * */
	public String find() {

		// 参数
		if (null != condition && condition.length() > 0) {
			try {
				condition = java.net.URLDecoder.decode(condition, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		// 查询数据库
		logger.info(condition);
		List<Map<String, Object>> list = testStrutsDao.findByCondition(condition);
		JSONArray jsonlist = JsonUtil.fromObject(list);
		dataMap.put("rows", jsonlist);
		logger.info(dataMap.toString());
		
		// 清空查询条件
		condition = null;
		return SUCCESS;
	}
	
}
