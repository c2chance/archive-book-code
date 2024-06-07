package com.car.util.upload;

import com.car.util.result.ResultData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上传文件接口.
 */
public interface UploadService {

    /**
     * 上传.
     *
     * @param request  上传请求
     * @param response 上传响应
     * @return 返回对象
     * @throws Exception 可能的异常
     */
    ResultData upload(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
