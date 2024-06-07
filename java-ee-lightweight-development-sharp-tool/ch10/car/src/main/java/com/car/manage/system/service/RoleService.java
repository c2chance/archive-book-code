package com.car.manage.system.service;

import com.car.manage.system.entity.Role;

import java.util.List;

/**
 * role 服务类.
 */
public interface RoleService {
    /**
     * 根据role id查询role.
     *
     * @param id role id
     * @return role
     */
    Role findById(Long id);

    /**
     * 创建role.
     *
     * @param role role
     */
    void create(Role role);

    /**
     * 根据id删除角色.
     *
     * @param id 角色id
     */
    void delete(Long id);

    /**
     * 跟新角色.
     *
     * @param role 角色
     */
    void update(Role role);

    /**
     * 查询所有role.
     *
     * @return List<Role>
     */
    List<Role> findAll();

    /**
     * 检查id不为指定id的名称是否存在.
     *
     * @param id   指定id
     * @param name 名称
     * @return true 如果存在， 否则false
     */
    Boolean isExist(Long id, String name);
}
