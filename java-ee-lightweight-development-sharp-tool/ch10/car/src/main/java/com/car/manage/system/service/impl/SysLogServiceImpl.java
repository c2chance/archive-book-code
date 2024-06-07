package com.car.manage.system.service.impl;

import com.car.manage.system.dao.ISysLogRepository;
import com.car.manage.system.entity.SysLog;
import com.car.manage.system.service.SysLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 系统日志服务类.
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private ISysLogRepository sysLogDao;

    @Override
    public SysLog insert(SysLog record) throws Exception {
        return sysLogDao.save(record);
    }
}
