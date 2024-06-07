package com.car.manage.system.dao;

import com.car.manage.system.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 组织访问数据库类.
 */
public interface IOrganizationRepository extends
        JpaRepository<Organization, Long>, JpaSpecificationExecutor<Organization> {

    /**
     * 查询所有组织.
     *
     * @param enabled enabled
     * @return List<Organization>
     */
    List<Organization> findByEnabled(Boolean enabled);

    /**
     * 根据name查询组织机构.
     *
     * @param name    name
     * @param enabled enabled
     * @return organization
     */
    Organization findByNameAndEnabled(String name, Boolean enabled);

    /**
     * 根据id和删除标识查询组织.
     *
     * @param id      组织id
     * @param enabled 删除标识
     * @return 组织
     */
    Organization findByIdAndEnabled(Long id, Boolean enabled);

    /**
     * 根据id删除父节点下所有组织.
     *
     * @param ids ids
     */
    @Modifying
    @Query("UPDATE Organization o SET o.enabled = FALSE WHERE o.id IN :ids ")
    void deleteByParentId(@Param("ids") List<Long> ids);

    /**
     * 根据父节点id查询所有子节点.
     *
     * @param id 父节点id
     * @return ids
     */
    @Query(value = "SELECT O2.* FROM (SELECT @r AS _id," +
            " (SELECT @r\\:= id FROM t_sys_organization WHERE parent_id = _id) AS id, @l\\:= @l + 1 AS lvl  " +
            "FROM (SELECT @r\\:= ?1, @l\\:= 0) vars, t_sys_organization h) O1 " +
            "JOIN t_sys_organization O2 ON O1._id = O2.parent_id WHERE O2.enabled = 1 ORDER BY O1.lvl",
            nativeQuery = true)
    List<Organization> findIdsByParentId(Long id);

    /**
     * 根据ids查询组织.
     *
     * @param ids ids
     * @return 组织
     */
    @Query("SELECT o FROM Organization o WHERE o.enabled = TRUE AND o.id IN :ids")
    List<Organization> findIds(@Param("ids") List<Long> ids);

    /**
     * 计算id不为指定id的名称的个数.
     *
     * @param id   指定id
     * @param name 证件名称
     * @param pId  pId
     * @return id不为指定id的名称的个数
     */
    @Query("select count(0) from Organization o where o.id <> :id and o.parent.id = :pId and o.name = :name " +
            "and o.enabled = true")
    Long countByType(@Param("id") Long id, @Param("pId") Long pId, @Param("name") String name);

    /**
     * 计算pId不为指定pId的名称的个数.
     *
     * @param pId  指定pId
     * @param name 证件名称
     * @return id不为指定id的名称的个数
     */
    @Query("select count(0) from Organization o where o.parent.id = :pId and o.name = :name " +
            "and o.enabled = true")
    Long countByParentAndName(@Param("pId") Long pId, @Param("name") String name);
}
