package com.manage.platform.action;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import com.fore.util.JsonUtil;
import com.fore.util.PinyinUtil;
import com.fore.util.ReadUrlString;
import com.manage.platform.entity.MANAGE_AREAEntity;
import com.manage.platform.service.IMANAGE_AREAService;
import com.manage.platform.service.IMANAGE_USERService;
import com.opensymphony.xwork2.Action;

public class MANAGE_AREAAction extends ActionBase  implements Action {

	private IMANAGE_AREAService imanage_areaservice;
	
	public IMANAGE_AREAService getImanage_areaservice() {
		return imanage_areaservice;
	}

	public void setImanage_areaservice(IMANAGE_AREAService imanage_areaservice) {
		this.imanage_areaservice = imanage_areaservice;
	}

	public String execute() throws Exception {
		return null;
	}
	
	/**
	 * 查询treegrid
	 * */
	public String findgrid() {
		
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
        //CacheManager cacheManager = new CacheManager();
        //Cache cache = cacheManager.getCache("users");
        //System.out.println(cache.getKeys());
		String test = imanage_areaservice.testA();
		List<Map<String, Object>> list = imanage_areaservice.findGridByCondition(condition);
		JSONArray jsonlist = JsonUtil.fromObject(list);
		
		jsonarr = jsonlist;
		
		logger.info(jsonlist.toString());
		
		// 清空查询条件
		condition = null;
		return SUCCESS;
	}
	
	/**
	 * 查询tree
	 * */
	public String findtree() {
		
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
		List<Map<String, Object>> list = imanage_areaservice.findTreeByCondition(condition);
		JSONArray jsonlist = JsonUtil.fromObject(list);
		
		jsonarr = jsonlist;
		
		logger.info(jsonlist.toString());
		
		// 清空查询条件
		condition = null;
		return SUCCESS;
	}
	
	/**
	 * 保存表单信息功能
	 * */
	public String save() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			ReadUrlString urlString = new ReadUrlString();
			String dataString = urlString.streamToString(request.getReader());
			String jsonString = URLDecoder.decode(dataString, "UTF-8");	
			MANAGE_AREAEntity maindata = (MANAGE_AREAEntity) JsonUtil.toBean(jsonString,MANAGE_AREAEntity.class);
			maindata.setSPELLNO(PinyinUtil.getFirstLetter(maindata.getNAME()));
			if (null==maindata.getICODE() || maindata.getICODE().isEmpty()) {
				maindata.setICODE(UUID.randomUUID().toString());
				//公用字段
				//InitCreate(maindata);				
				int returncount = imanage_areaservice.insert(maindata);
				dataMap.put("maindatauuid", maindata.getICODE());
				dataMap.put("savetype", "insert");
				dataMap.put("returncount", returncount);
			} else {
				//公用字段
				//InitModidy(maindata);				
				int returncount = imanage_areaservice.update(maindata);
				dataMap.put("savetype", "update");
				dataMap.put("returncount", returncount);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 删除单条数据功能
	 * */
	public String delete() {
		if (null != maindatauuid && maindatauuid.length() > 0) {
			try {
				maindatauuid = java.net.URLDecoder.decode(maindatauuid, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		int returncount = imanage_areaservice.delete(maindatauuid);
		
		dataMap.put("returncount", returncount);
		return SUCCESS;
	}

	/**
	 * 根据主键查找单条数据的功能
	 * */
	public String findByUUID() {
		if (null != maindatauuid && maindatauuid.length() > 0) {
			try {
				maindatauuid = java.net.URLDecoder
						.decode(maindatauuid, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		//condition = ".CDE01_00_600_00='" + maindatauuid + "'";
		condition = "{'ICODE' : '"+maindatauuid+"'}";
		List<Map<String,Object>> list = imanage_areaservice.findByCondition(condition, 0,1);
		condition = null;
		int returnsize = 0;
		if(null!=list)
			returnsize  = list.size();
		System.out.println(returnsize);
		if (returnsize > 0) {
			//主数据记录
			JSONArray jsonlist = JsonUtil.fromObject(list);
			JSONObject maindata = jsonlist.getJSONObject(0);
			dataMap.put("maindata",maindata);
			
		}
		return SUCCESS;
	}
}
