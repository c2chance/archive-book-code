package com.car.manage.system.service.impl;

import com.car.manage.system.service.SystemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 系统工具类.
 */
@Service
public class SystemServiceImpl implements SystemService {
    private static final Logger LOG = LoggerFactory.getLogger(SystemServiceImpl.class);
    private static String defaultDb;

    /**
     * 获取默认数据库的名称.
     *
     * @return 默认数据库名称
     */
    @Override
    public String getDefaultDb() {
        return this.defaultDb;
    }

    public static void setDefaultDb(String defaultDb) {
        SystemServiceImpl.defaultDb = defaultDb;
    }
}
