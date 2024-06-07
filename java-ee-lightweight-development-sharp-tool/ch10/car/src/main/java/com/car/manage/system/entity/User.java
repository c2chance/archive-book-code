package com.car.manage.system.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 后台用户.
 */
@Entity
@Table(name = "car_sys_user")
public class User extends Auditable {
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private Boolean isPasswordReset;

    private String telephone;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;


    private String realName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "car_t_sys_user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList; // 一个用户具有多个角色


    /**
     * 登录类型--管理员.
     */
    /**
     * 登录类型--驾驶员.
     */
    public enum symbol {
        /**
         * 管理员.
         */
        manager,
        /**
         * 车主.
         */
        driver
    }

    @Enumerated(EnumType.STRING)
    private User.symbol symbol;

    /**
     * 获取该用户所有role的名称.
     *
     * @return role名称列表
     */
    @Transient
    public Set<String> getRolesName() {
        List<Role> roles = getRoleList();
        Set<String> set = new HashSet<>();
        for (Role role : roles) {
            set.add(role.getName());
        }
        return set;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPasswordReset() {
        return isPasswordReset;
    }

    public void setPasswordReset(Boolean passwordReset) {
        isPasswordReset = passwordReset;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User.symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(User.symbol symbol) {
        this.symbol = symbol;
    }
}

