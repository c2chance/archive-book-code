package com.manage.platform.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
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
import com.manage.platform.entity.MANAGE_PERMISSIONEntity;
import com.manage.platform.service.IMANAGE_MODELService;
import com.manage.platform.service.IMANAGE_PERMISSIONService;
import com.opensymphony.xwork2.Action;

public class MANAGE_PERMISSIONAction extends ActionBase  implements Action {

	private IMANAGE_PERMISSIONService imanage_PERMISSIONservice;
	private IMANAGE_MODELService imanage_modelservice;
	
	public IMANAGE_MODELService getImanage_modelservice() {
		return imanage_modelservice;
	}

	public void setImanage_modelservice(IMANAGE_MODELService imanage_modelservice) {
		this.imanage_modelservice = imanage_modelservice;
	}

	public IMANAGE_PERMISSIONService getImanage_PERMISSIONservice() {
		return imanage_PERMISSIONservice;
	}

	public void setImanage_PERMISSIONservice(IMANAGE_PERMISSIONService imanage_PERMISSIONservice) {
		this.imanage_PERMISSIONservice = imanage_PERMISSIONservice;
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
		List<Map<String, Object>> list = imanage_PERMISSIONservice.findByCondition(condition,start, pageCount);
		JSONArray jsonlist = JsonUtil.fromObject(list);
		dataMap.put("rows", jsonlist);

		int count = imanage_PERMISSIONservice.countByCondition(condition);
		dataMap.put("total", count);

		logger.info(dataMap.toString());
		
		// 清空查询条件
		condition = null;
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
		
		//找打角色菜单关系列表
		condition = "{'ROLEICODE' : '"+maindatauuid+"'}";
		List<Map<String,Object>> listrolemodel = imanage_PERMISSIONservice.findByCondition(condition, 0,1000);
		
		//找打所有菜单
		List<Map<String,Object>> listmodel = imanage_modelservice.findTreeByCondition("");
		
		//循环设置checked
		SetChecked(listrolemodel,listmodel);
		
		JSONArray jsonlist = JsonUtil.fromObject(listmodel);
		
		jsonarr = jsonlist;
		
		logger.info(jsonlist.toString());
		
		// 清空查询条件
		condition = null;
		return SUCCESS;		
	}
	
	private void SetChecked(List<Map<String,Object>> listrolemodel,List<Map<String,Object>> listmodel){
		String icode = "";
		String MODELICODE="";
		List<Map<String,Object>> sublistmodel;
		
		for (int i = 0; i < listmodel.size(); i++) {
			Map<String,Object> mapmodel = listmodel.get(i);
			icode = mapmodel.get("id").toString();
			
			//设置节点是否选中
			for (int j = 0; j < listrolemodel.size(); j++) {
				Map<String,Object> maprolemodel = listrolemodel.get(j);
				MODELICODE = maprolemodel.get("MODELICODE").toString();
				if(icode.equals(MODELICODE)){
					mapmodel.put("checked", true);
					break;
				}
			}
			
			//是否有子节点，如果有，则循环处理
			if(mapmodel.containsKey("children")){
				sublistmodel = (List<Map<String,Object>>)mapmodel.get("children");
				SetChecked(listrolemodel,sublistmodel);
			}
		}
	}
	
	
	/**
	 * 保存表单信息功能
	 * */
	public String save() {
		try {
			//获取参数
			HttpServletRequest request = ServletActionContext.getRequest();
			ReadUrlString urlString = new ReadUrlString();
			String dataString = urlString.streamToString(request.getReader());
			String jsonString = URLDecoder.decode(dataString, "UTF-8");		
			
			//拆分参数
			JSONObject obj = JSONObject.fromObject(jsonString);
			String ROLEICODE =obj.containsKey("ROLEICODE")? obj.getString("ROLEICODE"):"";
			String MODELS =obj.containsKey("MODELS")? obj.getString("MODELS"):"";
			int returncount = 0;
			if(null!=ROLEICODE  && ROLEICODE .length()>0){
				
				//删除旧数据
				imanage_PERMISSIONservice.deleteByRoleicode(ROLEICODE);
								
				//增加新数据
				String[] modelarr = MODELS.split("\\|");
				for (int i = 0; i < modelarr.length; i++) {
					MANAGE_PERMISSIONEntity entity = new MANAGE_PERMISSIONEntity();
					entity.setICODE(UUID.randomUUID().toString());
					entity.setMODELICODE(modelarr[i]);
					entity.setROLEICODE(ROLEICODE);
					returncount += imanage_PERMISSIONservice.insert(entity);
				}
			}	
			dataMap.put("returncount", returncount);
			
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
		int returncount = imanage_PERMISSIONservice.delete(maindatauuid);
		
		dataMap.put("returncount", returncount);
		return SUCCESS;
	}

	
	
}
