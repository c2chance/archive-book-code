package com.manage.report.action;  

import java.io.InputStream;  
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
 
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;  
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
 
import com.fore.util.JsonUtil;
import com.manage.platform.action.ActionBase;
import com.manage.platform.entity.CardInssuerDetail;
import com.manage.report.dao.CardInssuerDetailDao;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;  
  
//文件下载   
public class FileDownloadQuery extends ActionBase implements Action,ServletRequestAware, ServletResponseAware{  
    

	
	   private HttpServletRequest request;  
	   private HttpServletResponse response;
	      
	   public void setServletRequest(HttpServletRequest request) {  
	       this.request=request;  
	   }  
	   
	   public void setServletResponse(HttpServletResponse response) {
			this.response=response;
			
		}

	
	private CardInssuerDetailDao cardInssuerDetailDao;





	public CardInssuerDetailDao getCardInssuerDetailDao() {
		return cardInssuerDetailDao;
	}

	public void setCardInssuerDetailDao(CardInssuerDetailDao cardInssuerDetailDao) {
		this.cardInssuerDetailDao = cardInssuerDetailDao;
	}
	
	protected static final Logger logger = LoggerFactory
			.getLogger("interfaceLogger");

	// Spring配置或者Action传入传出时使用，需要实现get，set
	
	protected String condition;
	
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
 
   //返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流   
    public String getDownloadFileQuery() throws Exception  
    {  
    	
    	
    	
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
		System.out.println("ssssssssssssssbbbbbbbbbbbbbbb");
		List<CardInssuerDetail> list = cardInssuerDetailDao.findByConditionList(condition);
		
		for(int i=0;i<list.size();i++){
			System.out.println("list========="+list.get(i).toString().toString());
			System.out.println("list实例1========="+list.get(i).getAdd2());
			System.out.println("list实例========="+list.get(i).getAdd_card());
			System.out.println("list实例========="+list.get(i).getBill_date());
			System.out.println("list实例========="+list.get(i).getCard_id());

		}

		List<CardInssuerDetail> novels = list;
		String srcdir = request.getRealPath("/");
		
	
		  
		    UUID uuid = UUID.randomUUID();  
		    System.out.println(uuid);  
		    
		 
		

       String path = srcdir + "/temp/"+uuid+".csv";
		System.out.println("path===="+path);
		
		
		
      // path = "d:/novels.csv";
    String flag=   cardInssuerDetailDao.export(novels,path,uuid);
   // request.setAttribute("flag",  flag);
    	System.out.println("flag测试====="+flag.toString());
    	
		System.out.println("testetststs");
//		JSONArray jsonlist = JsonUtil.fromObject(flag);
		
//		System.out.println("jsonlist1==="+jsonlist.toString());
//		
//		Map jsonMap = new HashMap(); 
//		jsonMap.put("jsonstr",flag);   //必须是map对象才能转换成json对象 
//		JSONObject json = JSONObject.fromObject(jsonMap); //要用到json-lib-2.3-jdk15.jar 
//		return  json.toString();
		
		
		
		dataMap.put("rows", flag);
		logger.info(dataMap.toString());
		System.out.println("dataMap==="+dataMap);
		// 清空查询条件
		condition = null;
		return SUCCESS;
    	
  
    }

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}  
     





}  