package com.car.manage.system.service.impl;

import com.car.manage.system.dao.IOrganizationRepository;
import com.car.manage.system.entity.Organization;
import com.car.manage.system.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 组织服务类.
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private IOrganizationRepository organizationRepository;

    @Override
    public void create(Organization organization) {
        organizationRepository.save(organization);
    }

    @Override
    public long countByName(Specification specification) {
        return organizationRepository.count(specification);
    }

    @Override
    public Organization findById(Long id) {
        return organizationRepository.findByIdAndEnabled(id, Boolean.TRUE);
    }

    @Override
    public void delete(long id) {
        Organization temp = organizationRepository.findOne(id);
        temp.setEnabled(Boolean.FALSE);
        organizationRepository.save(temp);
    }

    @Override
    public void deleteByParentId(List<Long> ids) {
        organizationRepository.deleteByParentId(ids);
    }

    @Override
    public List<Long> findIdsByParentId(Long id) {
        List<Organization> list = organizationRepository.findIdsByParentId(id);
        List<Long> ids = list.stream().map(Organization::getId).collect(Collectors.toList());
        return ids;
    }

    @Override
    public List<Organization> findByIds(List<Long> ids) {
        return organizationRepository.findIds(ids);
    }

    @Override
    public Organization update(Organization organization) {
        Organization temp = organizationRepository.findOne(organization.getId());
        temp.setName(organization.getName());
        return organizationRepository.save(temp);
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findByEnabled(Boolean.TRUE);
    }

    @Override
    public Organization findByName(String name) {
        return organizationRepository.findByNameAndEnabled(name, Boolean.TRUE);
    }

    @Override
    public Boolean isExist(Long id, Long pId, String name) {
        return organizationRepository.countByType(id, pId, name) > 0L;
    }

    @Override
    public Boolean isExistByParentAndName(Long pId, String name) {
        return organizationRepository.countByParentAndName(pId, name) > 0L;
    }

    @Override
    public void save(Object code, Object name, Object pcode) {
        if (organizationRepository.findOne(Long.valueOf(code.toString())) == null) {
            Organization org = new Organization();
            org.setId(Long.valueOf(code.toString()));
            if (!"0".equals(String.valueOf(pcode))) {
                Organization porg = organizationRepository.findOne(Long.valueOf(pcode.toString()));
                org.setParent(porg);
            }
            org.setName(String.valueOf(name));
            organizationRepository.save(org);
        }

    }

}
