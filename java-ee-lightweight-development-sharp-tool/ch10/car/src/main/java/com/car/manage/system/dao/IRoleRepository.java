package com.car.manage.system.dao;

import com.car.manage.system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 角色repository类.
 */
public interface IRoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    /**
     * 查询所有角色.
     *
     * @param enabled enabled
     * @return List<Role>
     */
    List<Role> findByEnabledOrderByCreatedAtDesc(Boolean enabled);

    /**
     * 根据id查下角色.
     *
     * @param enabled enabled
     * @param id      id
     * @return role
     */
    Role findByEnabledAndId(Boolean enabled, Long id);


    /**
     * 计算id不为指定id的名称的个数.
     *
     * @param id   指定id
     * @param name 名称
     * @return id不为指定id的名称的个数
     */
    @Query("select count(0) from Role r where r.id <> :id and r.name = :name and r.enabled=true")
    Long countByName(@Param("id") Long id, @Param("name") String name);
}
