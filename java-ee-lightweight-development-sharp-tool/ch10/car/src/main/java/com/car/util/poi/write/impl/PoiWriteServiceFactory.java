package com.car.util.poi.write.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.car.util.poi.write.PoiWriteService;

/**
 * 创建PoiExcelService实例,Workbook有HSSFWorkbook,XSSFWorkbook实例.
 */
public final class PoiWriteServiceFactory {
    private static Logger log = LoggerFactory.getLogger(PoiWriteServiceFactory.class);

    private PoiWriteServiceFactory() {
    }

    /**
     * 获取Workbook实例.
     *
     * @return poi write service
     */
    public static PoiWriteService getInstance() {
        PoiWriteService service = new PoiWriteServiceImpl();
        service.setWorkbook(new SXSSFWorkbook(PoiWriteService.ROW_ACCESS));
        return service;
    }

    /**
     * 获取Workbook实例.
     *
     * @param type hssf xssf sxssf type
     * @return poi write service
     */
    public static PoiWriteService getInstance(String type) {
        PoiWriteService service = new PoiWriteServiceImpl();
        //根据类型获取实例
        if (type == null || type.equalsIgnoreCase(PoiWriteService.TYPE_HSSF)) {
            service.setWorkbook(new HSSFWorkbook());
        } else if (type.equalsIgnoreCase(PoiWriteService.TYPE_XSSF)) {
            service.setWorkbook(new XSSFWorkbook());
        } else if (type.equalsIgnoreCase(PoiWriteService.TYPE_SXSSF)) {
            service.setWorkbook(new SXSSFWorkbook(PoiWriteService.ROW_ACCESS));
        }
        return service;
    }

    /**
     * 获取工作薄.
     *
     * @param request servlet request
     * @return list of poi write service
     */
    public static List<PoiWriteService> getPoiExcel(RequestContext request) {
        List<PoiWriteService> list = new ArrayList<PoiWriteService>();
        try {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fu = new ServletFileUpload(factory);
            fu.setHeaderEncoding("utf-8"); //解决中文问题
            List<?> items = fu.parseRequest(request);
            Iterator<?> it = items.iterator();

            while (it.hasNext()) {
                FileItem item = (FileItem) it.next();

                if (!item.isFormField()) {//文件

                    //过滤空文件
                    if (item.getName() == null || "".equals(item.getName().trim())) {
                        continue;
                    }

                    //验证文件类型
                    if (!Pattern.matches("(?i).*\\.(?:xls|xlsx)", item.getName())) {
                        throw new Exception("仅支持xls或xlsx文件");
                    }

                    list.add(getPoiExcelService(item.getName(), item.getInputStream()));
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return list;
    }

    /**
     * 获取工作薄.
     *
     * @param filename 文件路径
     * @return poi write service
     * @throws IOException exception
     */
    public static PoiWriteService getPoiExcelService(String filename) throws IOException {
        PoiWriteService service = null;
        InputStream is = null;
        try {
            is = new FileInputStream(filename);  //建立输入流
            service = getPoiExcelService(filename, is);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return service;
    }

    /**
     * 根据文件名生成对应的Workbook服务实例.
     *
     * @param filename 文件名
     * @param is       输入流
     * @return poi write service
     * @throws IOException exception
     */
    public static PoiWriteService getPoiExcelService(String filename, InputStream is) throws IOException {
        PoiWriteService service = new PoiWriteServiceImpl();
        filename = filename.toLowerCase();
        if (filename.endsWith("xls")) {
            service.setWorkbook(new HSSFWorkbook(is));
        } else if (filename.endsWith("xlsx")) {
            service.setWorkbook(new XSSFWorkbook(is));
        } else {
            throw new IOException("读取的不是excel文件");
        }
        return service;
    }

}
