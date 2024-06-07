package com.car.manage.system.service.impl;

import com.car.manage.system.dao.IRoleRepository;
import com.car.manage.system.entity.Role;
import com.car.manage.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * role 服务类.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findById(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public void create(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        Role role = roleRepository.findOne(id);
        role.setEnabled(Boolean.FALSE);
        roleRepository.save(role);
    }

    @Override
    public void update(Role role) {
        role.setCreatedAt(roleRepository.findByEnabledAndId(true, role.getId()).getCreatedAt());
        roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findByEnabledOrderByCreatedAtDesc(true);
    }

    @Override
    public Boolean isExist(Long id, String name) {
        return roleRepository.countByName(id, name) > 0L;
    }
}
