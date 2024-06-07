package com.car.util.download;

import com.car.util.result.ResultData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * download service.
 */
public interface DownloadService {
    /**
     * 下载.
     *
     * @param request  http servlet request
     * @param response http servlet response
     * @return result data.
     * @throws Exception exception
     */
    ResultData download(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
