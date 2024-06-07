package com.car.manage.system.dao;

import com.car.manage.system.entity.SysLog;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Sys log.
 */
public interface ISysLogRepository extends PagingAndSortingRepository<SysLog, Long>, JpaSpecificationExecutor<SysLog> {
}
