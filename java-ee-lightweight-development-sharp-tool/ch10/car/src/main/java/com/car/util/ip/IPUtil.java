package com.car.util.ip;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ip util.
 */
public final class IPUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(IPUtil.class);

    private IPUtil() {
    }

    /**
     * 描述：获取IP地址.
     *
     * @param request http servlet request
     * @return ip string
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "nuknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "nuknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "nuknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    /**
     * 描述：获取IP+[IP所属地址].
     *
     * @param request http servlet request
     * @return ip
     * @throws Exception sql exception
     */
    public static String getIpBelongAddress(HttpServletRequest request) throws Exception {
        String ip = getIpAddress(request);
        String belongIp = getIPbelongAddress(ip);
        return ip + belongIp;
    }

    /**
     * 描述：获取IP所属地址.
     *
     * @param ip ip
     * @return ip belong address
     * @throws Exception exception
     */
    public static String getIPbelongAddress(String ip) throws Exception {
        String ipAddress = "[]";
        try {
            // 淘宝提供的服务地址
            String context = call("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
            JSONObject fromObject = JSONObject.parseObject(context);
            String code = fromObject.getString("code");

            if (code.equals("0")) {
                JSONObject jsonObject = fromObject.getJSONObject("data");
                ipAddress = "[" + jsonObject.get("country") + "/" + jsonObject.get("city") + "]";
            }

        } catch (Exception e) {
            LOGGER.error("获取IP所属地址出错", e);
            throw e;
        }
        return ipAddress;
    }

    /**
     * 描述：获取Ip所属地址.
     *
     * @param urlStr url
     * @return address
     * @throws Exception exception
     */
    public static String call(String urlStr) throws Exception {

        try {
            URL url = new URL(urlStr);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            httpCon.setConnectTimeout(3000); //SUPPRESS
            httpCon.setDoInput(true);
            httpCon.setRequestMethod("GET");

            int code = httpCon.getResponseCode();

            if (code == 200) { //SUPPRESS
                return streamConvertToSting(httpCon.getInputStream());
            }
        } catch (Exception e) {
            LOGGER.error("获取IP所属地址出错", e);
            throw e;
        }
        return null;
    }

    /**
     * 描述：将InputStream转换成String.
     *
     * @param is input stream
     * @return string
     * @throws IOException exception
     */
    public static String streamConvertToSting(InputStream is) throws IOException {
        String tempStr = "";
        try {
            if (is == null) {
                return null;
            }

            ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
            byte[] by = new byte[1024]; //SUPPRESS
            int len = 0;

            while ((len = is.read(by)) != -1) {
                arrayOut.write(by, 0, len);
            }

            tempStr = new String(arrayOut.toByteArray());
        } catch (IOException e) {
            LOGGER.error("将InputStream转换成String出错", e);
            throw e;
        }
        return tempStr;
    }
}
