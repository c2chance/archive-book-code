package com.manage.platform.action;

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
import com.manage.platform.entity.MANAGE_ROLEEntity;
import com.manage.platform.service.IMANAGE_ROLEService;
import com.opensymphony.xwork2.Action;

public class MANAGE_ROLEAction extends ActionBase  implements Action {

	private IMANAGE_ROLEService imanage_ROLEservice;

	public IMANAGE_ROLEService getImanage_ROLEservice() {
		return imanage_ROLEservice;
	}

	public void setImanage_ROLEservice(IMANAGE_ROLEService imanage_ROLEservice) {
		this.imanage_ROLEservice = imanage_ROLEservice;
	}
	
	public String execute() throws Exception {
		return null;
	}

	/**
	 * 查询和分页功能
	 * */
	public String find() {

		// 当前页
		int intPage = Integer.parseInt((page == null || page == "0") ? "1": page);

		// 每页显示条数
		int pageCount = Integer.parseInt((rows == null || rows == "0") ? "20": rows);
		int start = (intPage - 1) * pageCount + 1;

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
		List<Map<String, Object>> list = imanage_ROLEservice.findByCondition(condition,start, pageCount);
		JSONArray jsonlist = JsonUtil.fromObject(list);
		dataMap.put("rows", jsonlist);

		int count = imanage_ROLEservice.countByCondition(condition);
		dataMap.put("total", count);

		logger.info(dataMap.toString());
		
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
			MANAGE_ROLEEntity maindata = (MANAGE_ROLEEntity) JsonUtil.toBean(jsonString,MANAGE_ROLEEntity.class);
			if (null==maindata.getICODE() || maindata.getICODE().isEmpty()) {
				maindata.setICODE(UUID.randomUUID().toString());
				//公用字段
				//InitCreate(maindata);				
				int returncount = imanage_ROLEservice.insert(maindata);
				dataMap.put("maindatauuid", maindata.getICODE());
				dataMap.put("savetype", "insert");
				dataMap.put("returncount", returncount);
			} else {
				//公用字段
				//InitModidy(maindata);				
				int returncount = imanage_ROLEservice.update(maindata);
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
		int returncount = imanage_ROLEservice.delete(maindatauuid);
		
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
		List<Map<String,Object>> list = imanage_ROLEservice.findByCondition(condition, 0,1);
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
