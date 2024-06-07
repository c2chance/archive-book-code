package com.manage.report.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.fore.util.DateJsonValueProcessor;
import com.fore.util.JsonUtil;
import com.manage.hibernate.User;
import com.manage.platform.action.ActionBase;
import com.manage.platform.entity.MANAGE_AREAEntity;
import com.manage.report.dao.IMANAGE_REPORTDao;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.report.service.UserService;

public class SendAmountAction extends ActionBase  implements Action {
	@Autowired
	private UserService userService;
	
	private IMANAGE_REPORTDao imanage_reportdao;
	public IMANAGE_REPORTDao getImanage_reportdao() {
		return imanage_reportdao;
	}
	public void setImanage_reportdao(IMANAGE_REPORTDao imanage_reportdao) {
		this.imanage_reportdao = imanage_reportdao;
	}

	public String execute() throws Exception {
		
		
/*		Map request2 = (Map)ActionContext.getContext().get("request");
		List<Emp> emps = imanage_reportdao.findAll();
		request2.put("emps",emps);
*/
		
/*		HttpServletRequest request2 = ServletActionContext.getRequest();
		request2.setAttribute("username","zhangsan");*/

		
/*		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write("zhangsan");*/
		
		
		
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = (request).getSession(true);
		MANAGE_AREAEntity usercode = (MANAGE_AREAEntity)session.getAttribute("area");
		//其他权限预留方法
		if(usercode.getNAME().equals("成都")){}
		
		//销售总部
		if(usercode.getNAME().equals("销售总部")){
			dataMap.clear();
			// 当前页
			int intPage = Integer.parseInt((page == null || page == "0") ? "1": page);
			// 每页显示条数
			int pageCount = Integer.parseInt((rows == null || rows == "0") ? "20": rows);
			int start = (intPage - 1) * pageCount + 1;
			// 界面输入的参数
			if (null != condition && condition.length() > 0) {
				try {
					condition = java.net.URLDecoder.decode(condition, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			//查询条件
			StringBuffer sbwhere = new StringBuffer();
			if(null!=condition && !condition.isEmpty()){
				JSONObject obj = JSONObject.fromObject(condition);
				String dateStart =obj.containsKey("dateStart")? obj.getString("dateStart"):"";
				String dateEnd =obj.containsKey("dateEnd")? obj.getString("dateEnd"):"";
				dateStart = dateStart.replace("-", "");
				dateEnd = dateEnd.replace("-", "");
				if((null!=dateStart  && dateStart .length()>0)&&(null!=dateEnd  && dateEnd .length()>0) ){
					sbwhere.append(" WHERE to_char(SENDDATE,'yyyymmdd')>="+"'"+dateStart+"'"+" and to_char(TAKEDATE,'yyyymmdd')<="+"'"+dateEnd+"'" );
				}	
			}
			
			//查询数据的SQL语句
			StringBuffer sbfind = new StringBuffer();
			
			// oracel语法
/*			sbfind.append(
			"SELECT CITY,\n" +
			"       GOODS,\n" + 
			"       AMOUNT,\n" + 
			"       RECEIVER,\n" + 
			"       SENDDATE,\n" + 
			"       TAKEDATE,\n" + 
			"       REMARK,\n" + 
			"       ROWNUM AS ROW_NUMBER\n" + 
			"  FROM GOODS_SENDCOUNT"
			+sbwhere);*/
			
			
			
			sbfind.append(
			"SELECT CITY,\n" +
			"       GOODS,\n" + 
			"       AMOUNT,\n" + 
			"       RECEIVER,\n" + 
			"       SENDDATE,\n" + 
			"       TAKEDATE,\n" + 
			"       REMARK\n" + 
			"  FROM GOODS_SENDCOUNT"
			+sbwhere);			
			
			
			// oracle语法 查询总条数的SQL语句
/*			StringBuffer sbcount = new StringBuffer();
			sbcount.append(
			"SELECT count(1)\n" +
			"  FROM (SELECT *\n" + 
			"          FROM GOODS_SENDCOUNT"
					+sbwhere+")");*/
			
			
			//查询总条数的SQL语句
			StringBuffer sbcount = new StringBuffer();
			sbcount.append(
			"SELECT count(1)\n" +"  FROM GOODS_SENDCOUNT"+sbwhere+"");
			
			
			
			
			
			//查询列表
			List<Map<String, Object>> list = imanage_reportdao.findData(sbfind, start, pageCount);
			//String username = "wxb";
			//List<User> users  = userService.queryUsers();
			//JSONArray jsonlist = JSONArray.fromObject(list);
			
			//改造
			//List<Map<String, Object>> listResult = imanage_reportdao.findDataResult(condition,start, pageCount);		
			
			//JSONArray jsonlist = JsonUtil.fromObject(list);
			JsonConfig jsonConfig = new JsonConfig();   
		    jsonConfig.registerJsonValueProcessor(Date.class , new DateJsonValueProcessor());
		    jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class , new DateJsonValueProcessor());	    
		    JSONArray jsonlist = JSONArray.fromObject(list, jsonConfig);
		   
			
			
			
			
			int count = imanage_reportdao.count(sbcount);	
			//int count2 = imanage_reportdao.count2(sbcount);	
			dataMap.put("rows", jsonlist);
			dataMap.put("total", count);
			//数据导出预留方法
			if(exportflag!=null){			
			}	
		}
		//清空查询条件
		exportflag = null;
		condition = null;
		return SUCCESS;
	}
}
