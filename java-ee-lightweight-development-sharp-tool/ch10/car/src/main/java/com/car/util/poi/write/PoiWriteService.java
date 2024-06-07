package com.car.util.poi.write;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * POI读、写EXCEL接口.
 */
public interface PoiWriteService {
    /**
     * HSSFWorkbook.
     */
    String TYPE_HSSF = "HSSF";
    /**
     * XSSFWorkbook.
     */
    String TYPE_XSSF = "XSSF";
    /**
     * SXSSFWorkbook.
     */
    String TYPE_SXSSF = "SXSSF";

    /**
     * 用于TYPE_SXSSF，保持在内存中10000行,超过行会刷新到磁盘,-1关掉auto-flushing和积累在内存中所有行.
     */
    int ROW_ACCESS = 10000; //SUPPRESS

    /**
     * 获取 SXSSFWorkbook.
     *
     * @return SXSSFWorkbook
     */
    SXSSFWorkbook getSXSSFWorkbook();

    /**
     * 获取 XSSFWorkbook.
     *
     * @return XSSFWorkbook
     */
    XSSFWorkbook getXSSFWorkbook();

    /**
     * 获取 HSSFWorkbook.
     *
     * @return HSSFWorkbook
     */
    HSSFWorkbook getHSSFWorkbook();

    /**
     * 用于获取和设置xls文件自定义属性信息.
     *
     * @return 属性信息.
     */
    DocumentSummaryInformation getDocumentInformationFromHSSF();

    /**
     * 用于获取和设置xls文件属性信息.
     *
     * @return 属性信息.
     */
    SummaryInformation getInformationFromHSSF();

    /**
     * 用于获取和设置xlsx文件属性信息.
     *
     * @return 属性信息.
     */
    CoreProperties getCorePropertiesFromXSSF();

    /**
     * 用于获取和设置xlsx文件属性信息.
     *
     * @return 属性信息.
     */
    CoreProperties getCorePropertiesFromSXSSF();

    /**
     * 加页.
     *
     * @param sheetName sheetName
     * @param list      数据
     * @param fields    属性
     * @param titles    titles
     * @param callback  回调
     * @param <T>       数据类型
     * @throws Exception 可能的异常
     */
    <T> void insertPage(String sheetName, List<T> list, String[] fields, String[] titles, InsertRowCallback callback)
            throws Exception;

    /**
     * 加行.
     *
     * @param sheetName sheetName
     * @param data      数据
     * @param <T>       数据类型
     * @throws Exception 可能的异常
     */
    <T> void insertRow(String sheetName, T data) throws Exception;

    /**
     * 加行.
     *
     * @param sheetName sheetName
     * @param data      数据
     * @param callback  回调
     * @param <T>       数据类型
     * @throws Exception 可能的异常
     */
    <T> void insertRow(String sheetName, T data, InsertRowCallback callback) throws Exception;

    /**
     * 加行.
     *
     * @param sheetName sheetName
     * @param data      数据
     * @param fields    属性
     * @param <T>       数据类型
     * @throws Exception 可能的异常
     */
    <T> void insertRow(String sheetName, T data, String[] fields) throws Exception;

    /**
     * 加行.
     *
     * @param sheetname sheet名称
     * @param data      数据
     * @param fields    字段
     * @param callback  回调函数
     * @param <T>       数据类型
     * @throws Exception 可能的异常
     */
    <T> void insertRow(String sheetname, T data, String[] fields, InsertRowCallback callback) throws Exception;

    /**
     * 写文件.
     *
     * @param filepath 文件路径
     * @throws IOException 可能的异常
     */
    void output(String filepath) throws IOException;

    /**
     * 读取单元格数据.
     *
     * @param cell cell
     * @return 值
     */
    Object getCellStringValue(Cell cell);

    /**
     * 获取workbook.
     *
     * @return workbook
     */
    Workbook getWorkbook();

    /**
     * 设置workbook.
     *
     * @param workbook workbook
     */
    void setWorkbook(Workbook workbook);

    /**
     * 获取页面大小.
     *
     * @return 页面大小
     */
    int getPageSize();

    /**
     * 设置页面大小.
     *
     * @param pageSize 页面大小
     */
    void setPageSize(int pageSize);

    /**
     * 获取数字.
     *
     * @return 数字
     */
    int getCount();

    /**
     * 页面大小.
     *
     * @return 页面输出大小
     */
    int getPageOutCount();

    /**
     * sheet map.
     *
     * @return sheetMap
     */
    Map<String, JSONObject> getSheetMap();
}
