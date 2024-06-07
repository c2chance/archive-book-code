package com.car.manage.system.service;

import com.car.manage.system.entity.Organization;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * 组织机构服务类.
 */
public interface OrganizationService {

    /**
     * 创建 organization.
     *
     * @param organization 组织
     */
    void create(Organization organization);

    /**
     * 这里只是一个例子.
     * 查询组织名称为name的组织的个数
     *
     * @param specification specification
     * @return 查询的条件数
     */
    long countByName(Specification specification);

    /**
     * 根据Organization id查询.
     *
     * @param id Organization id
     * @return Organization bean
     */
    Organization findById(Long id);

    /**
     * 根据id删除组织.
     *
     * @param id Organization id
     */
    void delete(long id);

    /**
     * 根据父类id删除组织.
     *
     * @param ids ids
     */
    void deleteByParentId(List<Long> ids);

    /**
     * 根据父类id查询所有子类.
     *
     * @param id id
     * @return ids
     */
    List<Long> findIdsByParentId(Long id);

    /**
     * 更新组织.
     *
     * @param organization organization bean
     * @return organization
     */
    Organization update(Organization organization);

    /**
     * 查询所有组织.
     *
     * @return List<Organization>
     */
    List<Organization> findAll();

    /**
     * 根据name查找组织.
     *
     * @param name name
     * @return organization bean
     */
    Organization findByName(String name);

    /**
     * 根据ids查询组织.
     *
     * @param ids ids
     * @return 组织
     */
    List<Organization> findByIds(List<Long> ids);

    /**
     * 检查id不为指定id的名称是否存在.
     *
     * @param id        指定id
     * @param paperName 名称
     * @param pId       pId
     * @return true 如果存在， 否则false
     */
    Boolean isExist(Long id, Long pId, String paperName);

    /**
     * 检查pId不为指定pId的名称是否存在.
     *
     * @param pId       指定pId
     * @param paperName 名称
     * @return true 如果存在， 否则false
     */
    Boolean isExistByParentAndName(Long pId, String paperName);

    /**
     * 保存组织信息.
     *
     * @param code  组织信息
     * @param name  组织信息
     * @param pcode 组织信息
     */
    void save(Object code, Object name, Object pcode);
}
