package com.car.manage.controller;

import com.car.manage.dto.PermissionDTO;
import com.car.manage.system.entity.Permission;
import com.car.manage.system.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;


/**
 * 权限类接口.
 */
@Controller
@RequestMapping("car/permissions")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 获取所有权限.
     *
     * @param map map
     * @return Message
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String findAll(Map<String, Object> map) {
        List<Permission> permissions = permissionService.findAll();
        map.put("permissions", PermissionDTO.convert(permissions));
        return "car/permissions/index";
    }
}
