package com.car.manage.system.service;

/**
 * 用来给Controller层传递系统信息.
 */
public interface SystemService {
    /**
     * 获取默认数据库名称.
     *
     * @return 默认数据库名称
     */
    String getDefaultDb();
}
