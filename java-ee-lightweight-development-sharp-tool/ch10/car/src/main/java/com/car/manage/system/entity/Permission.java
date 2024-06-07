package com.car.manage.system.entity;

import com.google.common.base.Strings;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 权限.
 */
@Entity
@Table(name = "car_sys_permission")
public class Permission extends Auditable {
    private static final String PERMISSION_FORMAT = "%s-%s";
    private static final String PERMISSION_SIMPLE_FORMAT = "%s";

    private String module;
    private String name;
    private String operation;
    private String code;

    /**
     * get Permission.
     *
     * @return permission
     */
    public String getPermission() {
        if (Strings.isNullOrEmpty(operation)) {
            return String.format(PERMISSION_SIMPLE_FORMAT, name);
        } else {
            return String.format(PERMISSION_FORMAT, name, operation);
        }
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
