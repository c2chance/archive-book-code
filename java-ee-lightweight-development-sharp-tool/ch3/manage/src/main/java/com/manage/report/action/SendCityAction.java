package com.manage.report.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.fore.util.JsonUtil;
import com.fore.util.ReadUrlString;
import com.manage.platform.action.ActionBase;
import com.manage.platform.entity.CardInssuerDetail;
import com.manage.platform.entity.MANAGE_AREAEntity;
import com.manage.platform.entity.MANAGE_USEREntity;
import com.manage.platform.service.IMANAGE_USERService;
import com.manage.report.dao.IMANAGE_REPORTDao;
import com.manage.report.dao.ITestStrutsDao;
import com.opensymphony.xwork2.Action;

public class SendCityAction extends ActionBase  implements Action {
	

	private IMANAGE_REPORTDao imanage_reportdao;
	
	public IMANAGE_REPORTDao getImanage_reportdao() {
		return imanage_reportdao;
	}

	public void setImanage_reportdao(IMANAGE_REPORTDao imanage_reportdao) {
		this.imanage_reportdao = imanage_reportdao;
	}

	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = (request).getSession(true);
		MANAGE_USEREntity userdata = (MANAGE_USEREntity)session.getAttribute("user");
		
		MANAGE_AREAEntity usercode = (MANAGE_AREAEntity)session.getAttribute("area");
		
//		System.out.println("user==="+userdata.getNAME());
//		System.out.println("user==="+userdata.getAREAICODE());
//		System.out.println("user==="+userdata.getLOGINNAME());
//		System.out.println("user==="+userdata.getNO());
//		System.out.println("user==="+userdata.getSTOPFLAG());
//		
//		System.out.println("usercode==="+usercode.getNO());
//		System.out.println("usercode==="+usercode.getCUSTOMNO());
//		System.out.println("usercode==="+usercode.getNAME());

		if(usercode.getNO().length()==3){
			System.out.println("这是市区123");
			
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
				System.out.println("dateStart1==="+dateStart);
				String dateEnd =obj.containsKey("dateEnd")? obj.getString("dateEnd"):"";
				System.out.println("dateEnd2==="+dateEnd);
				String tbUsername =obj.containsKey("tbUsername")? obj.getString("tbUsername"):"";
				
				if(null!=tbUsername  && tbUsername .length()>0){
					sbwhere.append(" FULLNAME like'%"+tbUsername+"%' ");
				}
				if((null!=dateStart  && dateStart .length()>0)&&(null!=dateEnd  && dateEnd .length()>0) ){
					sbwhere.append("  where to_char(carddate,'yyyymmdd')>="+"'"+dateStart+"'"+" and to_char(carddate,'yyyymmdd')<="+"'"+dateEnd+"'" );
				}	
			}
			
			//查询分页数据sql语句（特别注意，查询字段中一定要有这个字段：）
			StringBuffer sbfind = new StringBuffer();
			//sbfind.append(" SELECT TEST4.*, row_number() OVER(ORDER BY null) AS row_number FROM TEST4 ");
			System.out.println("usercode.getNO()==="+usercode.getNO());
			System.out.println("usercode.getName()==="+usercode.getNAME());

			//			sbfind.append("select chgmon,service_id,os,service_name,total_bytes,city_name,belong_area,rownum as row_number from T_AREADETAIL where stat = '1'");

			sbfind.append("SELECT CARDDATE,TEL,SOURCE,BILL_DATE,AREACODE,CONTACTTEL,CON_CARRIER,CONTACTNAME,CONTACTADD,RESERVEDATE,MSISDN,PAGESOURCE,REGUA,TOTALBYTES,USED_BYTES,CONTACTUA,TELUA,CONTACTIMEI,TELIMEI,PAYDATE,PAYTOTAL,IS_ALIPAY,IS_TENCENT,IS_BANK,IS_SOURCE,ROWNUM AS ROW_NUMBER FROM T_CARDREPORT WHERE PAYDATE IS NOT NULL AND AREACODE="+"'"+usercode.getNAME()+"'"+sbwhere);

			
			
			
			
			
			
			
			
			if(sbwhere.length()>0){
				sbfind.append(" where " + sbwhere.toString());
			}
			
			//查询总条数的sql语句
			StringBuffer sbcount = new StringBuffer();
			//sbcount.append(" SELECT count(1) FROM TEST4 ");
			//sbcount.append(" SELECT count(1) FROM (SELECT CARDDATE,TEL,SOURCE,AREACODE,CON_CARRIER,CONTACTNAME,CONTACTADD FROM T_CARDREPORT"+sbwhere+")");

			sbcount.append("SELECT count(1) FROM (CARDDATE,TEL,SOURCE,BILL_DATE,AREACODE,CONTACTTEL,CON_CARRIER,CONTACTNAME,CONTACTADD,RESERVEDATE,MSISDN,PAGESOURCE,REGUA,TOTALBYTES,USED_BYTES,CONTACTUA,TELUA,CONTACTIMEI,TELIMEI,PAYDATE,PAYTOTAL,IS_ALIPAY,IS_TENCENT,IS_BANK,IS_SOURCE FROM T_CARDREPORT WHERE PAYDATE IS NOT NULL AND AREACODE="+"'"+usercode.getNAME()+"'"+sbwhere+")");
			if(sbwhere.length()>0){
				sbcount.append(" where " + sbwhere.toString());
			}
			
			// 查询数据库 查询数据
			//System.out.println("sbfind==="+sbfind);

			List<Map<String, Object>> list = imanage_reportdao.findData(sbfind, start, pageCount);
			JSONArray jsonlist = JsonUtil.fromObject(list);
			System.out.println("jsonlist==="+jsonlist.toString());
			dataMap.put("rows", jsonlist);

			System.out.println("dataMap==="+dataMap);
			System.out.println("sbcount==="+sbcount);

			int count = imanage_reportdao.count(sbcount);
			dataMap.put("total", count);
			
			
			if(exportflag!=null){
				//System.out.println("sssssssssssssss");
				//List<CardInssuerDetail> novels = list;
				String srcdir = request.getRealPath("/");
				
			
				  
				    UUID uuid = UUID.randomUUID();  
				   // System.out.println(uuid);  
				    
				 
				

		       String path = srcdir + "/temp/"+uuid+".csv";
				//System.out.println("path===="+path);
				
				List<Map<String, Object>> listCount = imanage_reportdao.findCount(sbfind);
			
				
		      // path = "d:/novels.csv";
				//System.out.println("key==="+listCount.get(0).get("ZL"));
		
		    String flag=   imanage_reportdao.export(listCount,path,uuid);
		   // request.setAttribute("flag",  flag);
		    	//System.out.println("flag测试====="+flag.toString());
		    	
				//System.out.println("testetststs");
				
				dataMap.put("rows", flag);
				logger.info(dataMap.toString());
				//System.out.println("dataMap==="+dataMap);
				// 清空查询条件
				exportflag = null;
				condition = null;
				//return SUCCESS;
				
			}
			
		}


		

//		
//		sbcount.append(" SELECT count(1) FROM (SELECT b.CITY || ',' || b.BELONG_AREA || ',' || B.SERVICE_ID || ',' || C.OS || ',' ||" +
//				"       B.SERVICE_NAME || ',' || ROUND(SUM(TOTALUSE_BYTES) / 1024, 0)" +
//				"  FROM RPT_USER B, DATA201304_THJL_2GUSER_3GZD C" +
//				" WHERE B.SERVICE_ID = C.MSISDN" +
//				"  and (b.city_CODE = 'XXX' " +
//				"OR BELONG_CODE LIKE '%84848111%')" +
//				" GROUP BY b.CITY, B.SERVICE_ID, C.OS, B.SERVICE_NAME, B.BELONG_AREA)"
//				);
		
		
		
		
		
		if(usercode.getNO().length()>3){
			System.out.println("这是县城");
			
			
			
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
				String tbUsername =obj.containsKey("tbUsername")? obj.getString("tbUsername"):"";
				
				if(null!=tbUsername  && tbUsername .length()>0){
					sbwhere.append(" FULLNAME like'%"+tbUsername+"%' ");
				}	
			}
			
			//查询分页的sql语句（特别注意，查询字段中一定要有这个字段：）
			StringBuffer sbfind = new StringBuffer();
			//sbfind.append(" SELECT TEST4.*, row_number() OVER(ORDER BY null) AS row_number FROM TEST4 ");
			//			sbfind.append("select chgmon,service_id,os,service_name,total_bytes,city_name,belong_area,rownum as row_number from T_AREADETAIL where stat = '1'");
//			sbfind.append("select chgmon,service_id,os,service_name,total_bytes,city_name,belong_area,rownum as row_number from T_AREADETAIL where stat = '1' and city_code ="+"'"+usercode.getNO()+"'");

			sbfind.append("select chgmon,service_id,os,service_name,total_bytes,city_name,belong_area,rownum as row_number from T_AREADETAIL where stat = '1' and belong_code ="+"'"+usercode.getNO()+"'");
			                        
			
			
			
			
			if(sbwhere.length()>0){
				sbfind.append(" where " + sbwhere.toString());
			}
			
			//查询总条数的sql语句
			StringBuffer sbcount = new StringBuffer();
			//sbcount.append(" SELECT count(1) FROM TEST4 ");
//			sbcount.append("SELECT count(1) FROM (select chgmon,service_id,os,service_name,total_bytes,city_name,belong_area from T_AREADETAIL where stat = '1' and city_code ="+"'"+usercode.getNO()+"')");

			sbcount.append("SELECT count(1) FROM (select chgmon,service_id,os,service_name,total_bytes,city_name,belong_area from T_AREADETAIL where stat = '1' and belong_code ="+"'"+usercode.getNO()+"')");

			if(sbwhere.length()>0){
				sbcount.append(" where " + sbwhere.toString());
			}
			// 查询数据库
			List<Map<String, Object>> list = imanage_reportdao.findData(sbfind, start, pageCount);
			JSONArray jsonlist = JsonUtil.fromObject(list);
			//System.out.println("jsonlist==="+jsonlist.toString());
			dataMap.put("rows", jsonlist);

			System.out.println("sbcount="+sbcount);
			int count = imanage_reportdao.count(sbcount);
			dataMap.put("total", count);
			
			
			if(exportflag!=null){
				//System.out.println("sssssssssssssss");
				//List<CardInssuerDetail> novels = list;
				String srcdir = request.getRealPath("/");
				
			
				  
				    UUID uuid = UUID.randomUUID();  
				   // System.out.println(uuid);  
				    
				 
				

		       String path = srcdir + "/temp/"+uuid+".csv";
				//System.out.println("path===="+path);
				
				List<Map<String, Object>> listCount = imanage_reportdao.findCount(sbfind);
			
				
		      // path = "d:/novels.csv";
				//System.out.println("key==="+listCount.get(0).get("ZL"));
		
		    String flag=   imanage_reportdao.export(listCount,path,uuid);
		   // request.setAttribute("flag",  flag);
		    	//System.out.println("flag测试====="+flag.toString());
		    	
				//System.out.println("testetststs");
				
				dataMap.put("rows", flag);
				logger.info(dataMap.toString());
				//System.out.println("dataMap==="+dataMap);
				// 清空查询条件
				exportflag = null;
				condition = null;
				//return SUCCESS;
				
			}
			
			
			
		}
		
		
		
		
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
			
			// 查询条件
			StringBuffer sbwhere = new StringBuffer();
			if(null!=condition && !condition.isEmpty()){
				JSONObject obj = JSONObject.fromObject(condition);
				String dateStart =obj.containsKey("dateStart")? obj.getString("dateStart"):"";
				String dateEnd =obj.containsKey("dateEnd")? obj.getString("dateEnd"):"";
				dateStart = dateStart.replace("-", "");
				dateEnd = dateEnd.replace("-", "");
				String tbUsername =obj.containsKey("tbUsername")? obj.getString("tbUsername"):"";
				
				if(null!=tbUsername  && tbUsername .length()>0){
					sbwhere.append(" FULLNAME like'%"+tbUsername+"%' ");
				}	
					
				if((null!=dateStart  && dateStart .length()>0)&&(null!=dateEnd  && dateEnd .length()>0) ){
					sbwhere.append(" AND   to_char(carddate,'yyyymmdd')>="+"'"+dateStart+"'"+" and to_char(carddate,'yyyymmdd')<="+"'"+dateEnd+"'" );
				}	
	
			}
			
			// 查询分页的sql语句
			StringBuffer sbfind = new StringBuffer();
			
			// oracle语法
/*			sbfind.append(
			"SELECT CITY,\n" +
			"       GOODS,\n" + 
			"       AMOUNT,\n" + 
			"       RECEIVER,\n" + 
			"       TAKEDATE,\n" + 
			"       SENDDATE,\n" + 
			"       REMARK,\n" + 
			"       ROWNUM AS ROW_NUMBER\n" + 
			"  FROM GOODS_SENDCOUNT"
			+sbwhere);*/
			
			
			sbfind.append(
			"SELECT CITY,\n" +
			"       GOODS,\n" + 
			"       AMOUNT,\n" + 
			"       RECEIVER,\n" + 
			"       TAKEDATE,\n" + 
			"       SENDDATE,\n" + 
			"       REMARK\n" + 
			"  FROM GOODS_SENDCOUNT"
			+sbwhere);	
			
			
			
			
			

			// 查询总条数的sql语句
			StringBuffer sbcount = new StringBuffer();
			// oracle语法
/*			sbcount.append(
			"SELECT count(1)\n" +
			"  FROM (SELECT *\n" + 
			"          FROM GOODS_SENDCOUNT"
					+sbwhere+")");*/

			
			sbcount.append(
					"SELECT count(1)\n" +"  FROM GOODS_SENDCOUNT"+sbwhere+"");			
			
			
			
			
			
			//查询列表
			List<Map<String, Object>> list = imanage_reportdao.findData(sbfind, start, pageCount);
			JSONArray jsonlist = JsonUtil.fromObject(list);
			
			
/*			CacheManager singletonManager = CacheManager.create();
			singletonManager.addCache("testCache");
			Cache test = singletonManager.getCache("testCache");*/
			
			
			
			CacheManager singletonManager = CacheManager.create();
			//singletonManager.addCache("testCache");
			Cache test = singletonManager.getCache("users");
			Element getGreeting = test.get(0);
			//getGreeting.getKey();
			
/*			final CacheManager cacheManager = new CacheManager();
	        final Cache cache = cacheManager.getCache("users");
	        final Element getGreeting = cache.get("0");
	        cache.getKeys();*/
	        
	        
	        System.out.println(test.getSize());
	       // System.out.println(getGreeting.getObjectValue());
	        
	        
			int count = imanage_reportdao.count(sbcount);			
			dataMap.put("rows", jsonlist);
			dataMap.put("total", count);

			if(exportflag!=null && exportflag.equals("excel")){
				String srcdir = request.getRealPath("/");
				UUID uuid = UUID.randomUUID();  
		        String path = srcdir + "/temp/"+uuid+".xls";
                String flag = imanage_reportdao.exportExcel(list,path,uuid);
                flag = uuid.toString();
				dataMap.put("rows", flag);
				logger.info(dataMap.toString());
				exportflag = null;
				condition = null;				
			}
			
			if(exportflag!=null && exportflag.equals("csv")){
				String srcdir = request.getRealPath("/");
				UUID uuid = UUID.randomUUID();  
		        String path = srcdir + "/temp/"+uuid+".csv";
                String flag = imanage_reportdao.exportCsv(list,path,uuid);
				dataMap.put("rows", flag);
				logger.info(dataMap.toString());
				exportflag = null;
				condition = null;				
			}
			
		}
		
		// 清空查询条件
		exportflag = null;
		condition = null;
		
		return SUCCESS;

	}
	
}
