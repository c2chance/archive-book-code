package com.car.manage.dto;

import com.car.manage.system.entity.Permission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * PermissionDTO.
 */
public class PermissionDTO {
    /**
     * PermissionDTO 有参构造.
     *
     * @param name name
     */
    public PermissionDTO(String name) {
        this.name = name;
        this.values = new ArrayList<>();
    }

    private String name;
    private List<Pair> values;

    /**
     * 将permission 列表转换为 permission dto列表.
     *
     * @param permissions permission 列表
     * @return permission dto 列表
     */
    public static Collection<PermissionDTO> convert(List<Permission> permissions) {
        Map<String, PermissionDTO> dtos = new LinkedHashMap<>();
        permissions.forEach(p -> {
            PermissionDTO dto = dtos.get(p.getModule());

            if (dto == null) {
                dto = new PermissionDTO(p.getModule());
                dtos.put(p.getModule(), dto);
            }

            dto.add(p);
        });

        return dtos.values();
    }

    /**
     * 添加permission.
     *
     * @param permission permission
     */
    public void add(Permission permission) {
        this.values.add(new Pair(permission.getId(), permission.getPermission()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pair> getValues() {
        return values;
    }

    public void setValues(List<Pair> values) {
        this.values = values;
    }
}
