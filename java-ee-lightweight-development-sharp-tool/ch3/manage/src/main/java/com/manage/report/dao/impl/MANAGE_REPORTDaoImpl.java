package com.manage.report.dao.impl;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.manage.data.bean.Send;
import com.manage.platform.dao.impl.DaoImplBase;
import com.manage.report.dao.IMANAGE_REPORTDao;

public class MANAGE_REPORTDaoImpl extends DaoImplBase implements
		IMANAGE_REPORTDao {

	public static final Logger logger4j = Logger
			.getLogger(MANAGE_REPORTDaoImpl.class);

	public List<Map<String, Object>> findData(StringBuffer sql, int start,
			int count) {
		sql = pageSql(sql, start, count);
		logger.info("logback=" + sql.toString());
		logger4j.info("log4j=" + sql.toString());
		List<Map<String, Object>> list = namedjdbcTemplate.getJdbcOperations()
				.queryForList(sql.toString());
		return list;
	}

	public List<Map<String, Object>> findCount(StringBuffer sql) {
		List<Map<String, Object>> list = (List<Map<String, Object>>) namedjdbcTemplate
				.getJdbcOperations().queryForList(sql.toString());
		return list;
	}

	public int count(StringBuffer sql) {
		return namedjdbcTemplate.getJdbcOperations()
				.queryForInt(sql.toString());
	}
	
	public int count2(StringBuffer sql) {
		return namedjdbcTemplate.getJdbcOperations()
				.queryForInt(sql.toString());
	}

	public String export(List<Map<String, Object>> list, String fileName,
			UUID uuid) {
		return null;
	}

	public List<Map<String, Object>> findDataResult(String condition,
			int start, int count) {
		StringBuffer sbwhere = new StringBuffer();
		if (null != condition && !condition.isEmpty()) {
			JSONObject obj = JSONObject.fromObject(condition);
			String dateStart = obj.containsKey("dateStart") ? obj
					.getString("dateStart") : "";
			String dateEnd = obj.containsKey("dateEnd") ? obj
					.getString("dateEnd") : "";
			dateStart = dateStart.replace("-", "");
			dateEnd = dateEnd.replace("-", "");
			if ((null != dateStart && dateStart.length() > 0)
					&& (null != dateEnd && dateEnd.length() > 0)) {
				sbwhere.append(" WHERE to_char(SENDDATE,'yyyymmdd')>=" + "'"
						+ dateStart + "'"
						+ " and to_char(TAKEDATE,'yyyymmdd')<=" + "'" + dateEnd
						+ "'");
			}
		}
		StringBuffer sql = new StringBuffer();
/*		sql.append("SELECT CITY,\n" + "       GOODS,\n" + "       AMOUNT,\n"
				+ "       RECEIVER,\n" + "       SENDDATE,\n"
				+ "       TAKEDATE,\n" + "       REMARK,\n"
				+ "       ROWNUM AS ROW_NUMBER\n" + "  FROM GOODS_SENDCOUNT"
				+ sbwhere);*/
		
		
		sql.append("SELECT CITY,\n" + "       GOODS,\n" + "       AMOUNT,\n"
				+ "       RECEIVER,\n" + "       SENDDATE,\n"
				+ "       TAKEDATE,\n" + "       REMARK,\n"
				+ "       FROM GOODS_SENDCOUNT"
				+ sbwhere);
		
		sql = pageSql(sql, start, count);
		logger.info(sql.toString());
		List<Map<String, Object>> list = namedjdbcTemplate.getJdbcOperations()
				.queryForList(sql.toString());
		return list;
	}

	public boolean addGoods() {
		/** 插入数据 */
		// jdbcTemplate.update("INSERT INTO GOODS_SENDCOUNT(CITY,GOODS,AMOUNT,RECEIVER,TAKEDATE,SENDDATE,REMARK)"
		// +
		// "VALUES('张掖','丝绸','300','',null,null,'华丽')");
		// jdbcTemplate.update("INSERT INTO GOODS_SENDCOUNT(CITY,GOODS,AMOUNT,RECEIVER,TAKEDATE,SENDDATE,REMARK)"
		// +
		// "VALUES(?,?,'300','',null,null,?)",new Object[] {"郑州", "土豆", "新鲜" });

		/** 更新数据 */
		// jdbcTemplate.update("UPDATE GOODS_SENDCOUNT SET RECEIVER='阿狸' WHERE RECEIVER = '提莫'");
		// jdbcTemplate.update("UPDATE GOODS_SENDCOUNT SET RECEIVER= ? WHERE RECEIVER = ?",new
		// Object[] {"提莫", "阿狸"});

		/** 删除数据 */
		// jdbcTemplate.update("DELETE FROM GOODS_SENDCOUNT WHERE RECEIVER = '泰隆'");
		// jdbcTemplate.update("DELETE FROM GOODS_SENDCOUNT WHERE RECEIVER = ?",new
		// Object[] {"泰隆"});

		/** 查询数据 */
		// List queryRecord =
		// jdbcTemplate.queryForList("SELECT * FROM GOODS_SENDCOUNT");
		// Iterator it = queryRecord.iterator();
		// while(it.hasNext()) {
		// Map userMap = (Map) it.next();
		// System.out.println(userMap.get("CITY"));
		// System.out.println(userMap.get("GOODS"));
		// System.out.println(userMap.get("RECEIVER"));
		// }

		/** 插入数据 */
		// Map parameters = new HashMap();
		// parameters.put("CITY", "南京");
		// parameters.put("GOODS", "绿豆");
		// parameters.put("REMARK", "质量好");
		// namedjdbcTemplate.update("INSERT INTO GOODS_SENDCOUNT(CITY,GOODS,AMOUNT,RECEIVER,TAKEDATE,SENDDATE,REMARK)"
		// +
		// "VALUES(:CITY,:GOODS,'300','',null,null,:REMARK)", parameters);

		/** 查询数据 */
		String sql = "SELECT * FROM GOODS_SENDCOUNT";
		// List list =
		// namedjdbcTemplate.getJdbcOperations().queryForList(sql.toString());
		List<Map<String, Object>> list = namedjdbcTemplate.getJdbcOperations()
				.queryForList(sql.toString());

		/*
		 * if(list.size()==0){ return false; }else{ return true; }
		 */
		String sqlMap = "SELECT CITY FROM GOODS_SENDCOUNT WHERE CITY = '杭州'";
		Map map = namedjdbcTemplate.getJdbcOperations().queryForMap(sqlMap);
		String city = (String) map.get("CITY");
		System.out.println(city);
		// String sqlCount = "SELECT COUNT(*) FROM GOODS_SENDCOUNT";
		// int resultCount =
		// namedjdbcTemplate.getJdbcOperations().queryForInt(sqlCount);
		return true;
	}

	// 导出Excel代码
	public String exportExcel(List<Map<String, Object>> list, String fileName,
			UUID uuid) {

		// 创建一个webbook
		HSSFWorkbook wb = new HSSFWorkbook();
		// 在webbook中添加一个sheet
		HSSFSheet sheet = wb.createSheet("发货城市统计");
		// 在sheet中添加表头第0行
		HSSFRow row = sheet.createRow((int) 0);
		// 创建格式
		HSSFCellStyle style = wb.createCellStyle();
		// 格式居中
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 对单元格赋值
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("城市");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("产品");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("数量");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("接收人");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("接收时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("发送时间");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("备注");
		cell.setCellStyle(style);

		// 使用实体Bean
		// List list = cityBean.getCity();

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			// 创建单元格 赋值
			row.createCell((short) 0).setCellValue(
					list.get(i).get("CITY").toString());
			row.createCell((short) 1).setCellValue(
					list.get(i).get("GOODS").toString());
			row.createCell((short) 2).setCellValue(
					list.get(i).get("AMOUNT").toString());
			row.createCell((short) 3).setCellValue(
					list.get(i).get("RECEIVER").toString());
			row.createCell((short) 4).setCellValue(
					list.get(i).get("TAKEDATE").toString());
			row.createCell((short) 5).setCellValue(
					list.get(i).get("SENDDATE").toString());
			row.createCell((short) 6).setCellValue(
					list.get(i).get("REMARK").toString());
			// cell.setCellValue(new
			// SimpleDateFormat("yyyy-mm-dd").format(cityBean.getCity()));
		}
		// 将文件存到指定位置
		try {
			FileOutputStream fout = new FileOutputStream(fileName);
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	// 导出CSV文件代码
	public String exportCsv(List<Map<String, Object>> list, String fileName,
			UUID uuid) {

		/**
		 * 把数据按一定的格式写到CSV文件中
		 * 
		 * @param fileName
		 *            CSV文件完整路径
		 */

		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			// 输出标题头
			String title = "城市,产品,数量,接收人,接收时间,发送时间,备注\r\n";
			fw.write(title);
			String content = null;
			for (int i = 0; i < list.size(); i++) {
				// 注意列之间用","间隔 写完一行需要回车换行"\r\n"
				content = list.get(i).get("CITY").toString() + ","
						+ list.get(i).get("GOODS").toString() + ","
						+ list.get(i).get("AMOUNT").toString() + ","
						+ list.get(i).get("RECEIVER").toString() + ","
						+ list.get(i).get("TAKEDATE").toString() + ","
						+ list.get(i).get("SENDDATE").toString() + ","
						+ list.get(i).get("REMARK").toString() + "\r\n";
				fw.write(content);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String flag = uuid.toString();
		return flag;
	}

	public boolean addGoods2(Send sendEntity) {
		String sql = "INSERT INTO GOODS_SENDCOUNT(CITY,GOODS,AMOUNT,RECEIVER,TAKEDATE,SENDDATE,REMARK)"
				+ "VALUES(" + "'"
				+ sendEntity.getCity()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getGoods()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getAmount()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getReceiver()
				+ "'"
				+ ","
				+ "to_date("
				+ "'"
				+ sendEntity.getSenddate()
				+ "'"
				+ ","
				+ "'YYYY-MM-DD'"
				+ ")"
				+ ","
				+ "to_date("
				+ "'"
				+ sendEntity.getTakedate()
				+ "'"
				+ ","
				+ "'YYYY-MM-DD'"
				+ ")"
				+ ","
				+ "'"
				+ sendEntity.getRemark()
				+ "'" + ")";
		jdbcTemplate.update(sql);
		return true;
	}
	
	
	
	public boolean addGoods(Send sendEntity) {
		String sql = "INSERT INTO GOODS_SENDCOUNT(CITY,GOODS,AMOUNT,RECEIVER,TAKEDATE,SENDDATE,REMARK)"
				+ "VALUES(" + "'"
				+ sendEntity.getCity()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getGoods()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getAmount()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getReceiver()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getSenddate()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getTakedate()
				+ "'"
				+ ","
				+ "'"
				+ sendEntity.getRemark()
				+ "'" + ")";
		jdbcTemplate.update(sql);
		return true;
	}

	@Override
	public List<Map<String, Object>> queryUsers(StringBuffer sbfind, int start, int pageCount) {
		// TODO Auto-generated method stub
		return null;
	}


}
