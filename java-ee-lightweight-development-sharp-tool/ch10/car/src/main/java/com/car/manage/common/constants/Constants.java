package com.car.manage.common.constants;

/**
 * 常量类.
 */
public final class Constants {


    private Constants() {
    }

    /**
     * 默认页面大小.
     */
    public static final int DEFAULT_PAGE_SIZE = 30;

    /**
     * 默认编码格式.
     */
    public static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * 登录用户的 用户信息的KEY. //TODO
     */
    public static final String SESSION_USER_KEY = "Admin";
    /**
     * 登录用户的 用户信息的KEY. //TODO
     */
    public static final String SESSION_DRIVER_KEY = "Driver";
    /**
     * 租户与用户名之间的分隔符.
     */
    public static final String TENANT_SPLITER = "@";

    /**
     * 日志类型: 访问日志.
     */
    public static final String TYPE_ACCESS = "1";
    /**
     * 日志类型： 错误日志类型.
     */
    public static final String TYPE_EXCEPTION = "2";

    /**
     * info message.
     */
    public static final String INFO = "__INFO";
    /**
     * warn message.
     */
    public static final String WARN = "__WARN";
    /**
     * error message.
     */
    public static final String ERROR = "__ERROR";
    /**
     * http method post.
     */
    public static final String HTTP_METHOD_POST = "POST";
    /**
     * http method DELETE.
     */
    public static final String HTTP_METHOD_DELETE = "DELETE";
    /**
     * http method PUT.
     */
    public static final String HTTP_METHOD_PUT = "PUT";
    /**
     * http method GET.
     */
    public static final String HTTP_METHOD_GET = "GET";
    /**
     * 根节点.
     */
    public static final String ROOT = "根节点";
    /**
     * 默认分页大小.
     */
    public static final Integer PAGE_SIZE = 6;
    /**
     * 证件类型 PAPERS_TYPE.
     */
    public static final String PAPERS_TYPE = "0";
    /**
     * 签名类型 SIGN_TYPE.
     */
    public static final String SIGN_TYPE = "1";
    /**
     * TOKEN.
     */
    public static final String TOKEN = "147258963";
    /**
     * 校区一.
     */
    public static final String CAMPUS_ONE = "校区一";
    /**
     * 校区二.
     */
    public static final String CAMPUS_TWO = "校区二";
    /**
     * 代理端口号.
     */
    public static final int PROXY_PORT = 8007;
    /**
     * 学校大门url.
     */
    public static final String SCHOOL_GATE = "/school-gates";
    /**
     * 组织url.
     */
    public static final String SCHOOL_ORGS = "/orgs";
    /**
     * 教职工信息url.
     */
    public static final String SCHOOL_TEACHER = "/teachers";

    /**
     * pass url.
     */
    public static final String SCHOOL_PASS = "/pass";

    /**
     * 外来车辆url.
     */
    public static final String SCHOOL_TRAFFIC = "/traffic-report";
    /**
     * salt.
     */
    public static final String SALT = "car";
    /**
     *
     * 百度地图经纬度反查.
     */
    public static final Object BAIDU_MAP_URL = "http://api.map.baidu.com/geocoder/v2/?location=";

}
