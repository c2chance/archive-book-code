package com.car.util.download;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

/**
 * download util.
 */
public final class DownloadUtil {
    private static final Logger LOG = LoggerFactory.getLogger(DownloadUtil.class);

    private DownloadUtil() {
    }

    /**
     * 文件下载.<br/>
     * 若报错：getOutputStream() has already been called for this response<br/>
     * 则需要添加以下两行代码：<br/>
     * out.clear();<br/>
     * out = pageContext.pushBody();<br/>
     *
     * @param response response
     * @param workbook POI工作薄
     * @param filename 文件名
     * @throws Exception exception
     */
    public static void download(HttpServletResponse response, Workbook workbook, String filename) throws Exception {
        try {
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            //response.setContentType("application/x-msdownload");
            //2.设置文件头：
            // 最后一个参数是设置下载文件名(new String(filename.getBytes("utf-8"), "ISO-8859-1")解决中文被过滤问题)
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(filename, "utf-8"));
            response.setCharacterEncoding("utf-8");
            ServletOutputStream os = response.getOutputStream();
            workbook.write(os);

            //注意看以下几句的使用
            os.flush();
            os.close();
            os = null;
            response.flushBuffer();
            LOG.info("file download success");
        } catch (Exception e) {
            LOG.error("下载失败：" + e.getMessage(), e);
            throw new Exception("下载失败", e);
        }
    }

    /**
     * 文件下载.
     *
     * @param response response
     * @param pathname 文件全路径
     * @param filename 文件名
     * @throws Exception exception
     */
    public static void download(HttpServletResponse response, String pathname, String filename) throws Exception {
        try {
            //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
            response.setContentType("multipart/form-data");
            //2.设置文件头：最后一个参数是设置下载文件名
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(filename, "utf-8"));
            response.setCharacterEncoding("utf-8");

            File file = new File(pathname);
            ServletOutputStream out = null;

            if (file.exists()) {
                LOG.error("file not fond!");
            } else {
                FileInputStream inputStream = new FileInputStream(file);

                //3.通过response获取ServletOutputStream对象(out)
                out = response.getOutputStream();

                int b = 0;
                byte[] buffer = new byte[512];

                while (b != -1) {
                    b = inputStream.read(buffer);
                    //4.写到输出流(out)中
                    out.write(buffer, 0, b);
                }
                inputStream.close();
                out.close();
                out.flush();
                LOG.info("file download success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("下载失败：" + e.getMessage(), e);
            throw new Exception("下载失败", e);
        }
    }
}
