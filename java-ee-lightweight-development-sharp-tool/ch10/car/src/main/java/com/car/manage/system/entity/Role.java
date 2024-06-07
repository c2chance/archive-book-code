package com.car.manage.system.entity;

import com.car.manage.common.constants.New;
import com.car.manage.common.constants.Update;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色.
 */
@Entity
@Table(name = "car_sys_role")
public class Role extends Auditable {

    /**
     * default init.
     */
    public Role() {

    }

    /**
     * init with id.
     *
     * @param id id
     */
    public Role(Long id) {
        super();
        super.setId(id);
    }

    @NotEmpty(message = "名称不允许为空", groups = {New.class, Update.class})
    private String name;
    private String roleId;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "car_role_permission",
            joinColumns = {@JoinColumn(name = "roles_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")}
    )
    private List<Permission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取该角色所有权限的名称.
     *
     * @return 权限列表
     */
    public Set<String> getPermissionsName() {
        if (permissions == null) {
            return Collections.EMPTY_SET;
        }
        List<Permission> list = permissions;
        Set<String> set = new HashSet<>();
        for (Permission permission : list) {
            set.add(permission.getCode());
        }
        return set;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
