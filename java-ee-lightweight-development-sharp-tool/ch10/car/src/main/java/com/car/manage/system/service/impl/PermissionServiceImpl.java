package com.car.manage.system.service.impl;

import com.car.manage.system.dao.IPermissionRepository;
import com.car.manage.system.entity.Permission;
import com.car.manage.system.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限服务类.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private IPermissionRepository permissionRepository;

    @Override
    public void create(Permission permission) {
        permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }
}
