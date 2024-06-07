package com.car.manage.system.service;

import com.car.manage.system.entity.Permission;

import java.util.List;

/**
 * 权限服务类.
 */
public interface PermissionService {
    /**
     * 创建/保存permission.
     *
     * @param permission permission
     */
    void create(Permission permission);

    /**
     * 查询所有权限.
     *
     * @return List<Permission>
     */
    List<Permission> findAll();
}
