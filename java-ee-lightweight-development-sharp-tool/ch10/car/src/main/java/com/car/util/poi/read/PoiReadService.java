package com.car.util.poi.read;

import com.car.util.poi.read.impl.ReadSheetHandler;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.RequestContext;

import java.io.InputStream;
import java.util.List;

/**
 * 读取service.
 */
public interface PoiReadService {
    /**
     * 读取EXCEL文件.
     *
     * @param is                   输入流
     * @param sheetnamePattern     sheet 名字
     * @param sheetContentsHandler handler
     * @throws Exception 可能的异常
     */
    void read(InputStream is, String sheetnamePattern, ReadSheetHandler sheetContentsHandler) throws Exception;

    /**
     * 装上传的文件保存在（临时）路径.
     *
     * @param request servlet request
     * @return 临时路径列表
     * @throws Exception 可能的异常
     */
    List<String> listFilePath(HttpServletRequest request) throws Exception;

	List<String> listFilePath(RequestContext request) throws Exception;
}
