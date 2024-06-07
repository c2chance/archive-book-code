package com.car.manage.system.service;

import com.car.manage.system.entity.SysLog;

/**
 * 系统日志服务.
 */
public interface SysLogService {
    /**
     * 插入日志.
     *
     * @param record 日志信息
     * @return syslog
     * @throws Exception 异常
     */
    SysLog insert(SysLog record) throws Exception;
}
