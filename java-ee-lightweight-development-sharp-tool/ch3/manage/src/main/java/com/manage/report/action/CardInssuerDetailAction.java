package com.manage.report.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.fore.util.JsonUtil;
import com.fore.util.ReadUrlString;
import com.manage.platform.action.ActionBase;
import com.manage.platform.entity.CardInssuerDetail;
import com.manage.platform.entity.MANAGE_USEREntity;
import com.manage.platform.service.IMANAGE_USERService;
import com.manage.report.dao.CardInssuerDetailDao;
import com.manage.report.dao.ITestStrutsDao;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;



public class CardInssuerDetailAction extends ActionBase  implements Action,ServletRequestAware, ServletResponseAware  {

	private CardInssuerDetailDao cardInssuerDetailDao;





	public CardInssuerDetailDao getCardInssuerDetailDao() {
		return cardInssuerDetailDao;
	}

	public void setCardInssuerDetailDao(CardInssuerDetailDao cardInssuerDetailDao) {
		this.cardInssuerDetailDao = cardInssuerDetailDao;
	}

	
       private HttpServletRequest request;  
	   private HttpServletResponse response;  
	      
	   public void setServletRequest(HttpServletRequest request) {  
	       this.request=request;  
	   }  
	 
	   public void setServletResponse(HttpServletResponse response) {  
	        this.response=response;  
	  }  





	
	
	public String execute() throws Exception {
		request.setAttribute("username","zhangsan");
        //return null;
        return SUCCESS;
	}
	
	
	
	
	
//	private String fileName;
	private String path;

	
    private int number ;  
    
    private String fileName;  
   public int getNumber() {  
        return number;  
   }  
  
    public void setNumber(int number) {  
        this.number = number;  
    }  
     
    public String getFileName() {  
        return fileName;  
   }  
  
    public void setFileName(String fileName) {  
       this.fileName = fileName;  
   }  
	
	
	
	/**
	 * 查询和分页功能
	 * */
	public String find() {
System.out.println("查询方法");
		// 参数
		if (null != condition && condition.length() > 0) {
			try {
				condition = java.net.URLDecoder.decode(condition, "UTF-8");
				System.out.println("conditionCS1==="+condition);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		// 查询数据库
		logger.info(condition);
		System.out.println("conditionCS2==="+condition);
		List<Map<String, Object>> list = cardInssuerDetailDao.findByCondition(condition);
		
//		for(int i=0;i<list.size();i++){
//			System.out.println("list123========="+list.get(i).toString());
//
//
//		}
		System.out.println("testetststs");
		JSONArray jsonlist = JsonUtil.fromObject(list);
		
		System.out.println("jsonlist1==="+jsonlist);
		
		dataMap.put("rows", jsonlist);
		logger.info(dataMap.toString());
		
		// 清空查询条件
		condition = null;
		return SUCCESS;
		
		
		
		
		
		
		

	}
	
	
	
    /**
     * 导出数据到文件
     * @param request
     * @param response
     * @throws QueryException
     */
	
	
	
	public String export() {
		 System.out.println("sssssssssssss");
		System.out.println("123");
		// 参数
		if (null != condition && condition.length() > 0) {
			try {
				condition = java.net.URLDecoder.decode(condition, "UTF-8");
				System.out.println("conditionCS1==="+condition);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		// 查询数据库
		logger.info(condition);
		System.out.println("conditionCS==="+condition);
		List<CardInssuerDetail> list = cardInssuerDetailDao.findByConditionList(condition);
		
		for(int i=0;i<list.size();i++){
			System.out.println("list========="+list.get(i).toString());
			System.out.println("list实例========="+list.get(i).getAdd2());
			System.out.println("list实例========="+list.get(i).getAdd_card());
			System.out.println("list实例========="+list.get(i).getBill_date());
			System.out.println("list实例========="+list.get(i).getCard_id());

		}

		List<CardInssuerDetail> novels = list;
		String srcdir = request.getRealPath("/");

        String path = srcdir + "/temp/novels.csv";
		System.out.println("path===="+path);
       // path = "d:/novels.csv";
    // String flag=   cardInssuerDetailDao.export(novels,path);

//if(flag=="end"){
//	System.out.println("flag===="+flag);
//	InputStream test = cardInssuerDetailDao.getDownloadFile();
//}
//       
         
         
         
		return SUCCESS;

        

	
	}
	
	

	
	
	
}
