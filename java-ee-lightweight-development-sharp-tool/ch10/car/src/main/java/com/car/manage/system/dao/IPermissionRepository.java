package com.car.manage.system.dao;

import com.car.manage.system.entity.Permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 权限查询接口.
 */
public interface IPermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {
//    /**
//     * 根据roleId返回用户对应的权限.
//     * @param roleId  角色id
//     * @return  用户对应的权限
//     */
//    @Query("SELECT bean from Permission bean where bean.id in(select " +
//            "permission_id from Role where roleId=?1)")
//    List<Permission> findPermissionOverRoleId(int roleId);

}
