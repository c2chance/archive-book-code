package com.car.manage.system.service.impl;

import com.car.manage.common.constants.Constants;
import com.car.manage.system.dao.IOrganizationRepository;
import com.car.manage.system.dao.IRoleRepository;
import com.car.manage.system.dao.IUserRepository;
import com.car.manage.system.entity.Role;
import com.car.manage.system.entity.User;
import com.car.manage.system.search.UserSearch;
import com.car.manage.system.service.UserService;
import com.car.manage.utils.CryptographyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用户服务类.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IOrganizationRepository organizationRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    /**
     * @see com.car.manage.service.UserService#findAll
     */
    public Page<User> findAll(UserSearch userSearch) {
        Page<User> users = userRepository.findAll(userSearch.getSpecification(), userSearch.getPageInfo());
        return users;
    }

    @Override
    /**
     * @see com.car.manage.service.UserService#create
     */
    public void create(User user) {
        user.setOrganization(organizationRepository.findOne(user.getOrganization().getId()));
        user.setSymbol(User.symbol.manager);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsernameAndEnabled(username, true);
        return user;
    }

    @Override
    public User save(User user) {
        user.setSymbol(User.symbol.driver);
        return userRepository.save(user);
    }

    @Override
    /**
     * @see com.car.manage.service.UserService#update
     */
    public void update(User user) {
        if (user.getOrganization().getId() != null) {
            user.setOrganization(organizationRepository.findOne(user.getOrganization().getId()));
        }
        User user1 = userRepository.findById(user.getId());
        user.setCreatedAt(user1.getCreatedAt());
        user.setRoleList(userRepository.findOne(user.getId()).getRoleList());
        user.setSymbol(User.symbol.manager);
        userRepository.save(user);
    }

    @Override
    /**
     * @see com.car.manage.service.UserService#delete
     */
    public void delete(Long id) {
        User user = userRepository.findOne(id);
        user.setEnabled(false);
        userRepository.save(user);
    }

    @Override
    /**
     * @see com.car.manage.service.UserService#isExist
     */
    public Boolean isExist(Long id, String username) {
        return userRepository.countByName(id, username) > 0L;
    }


    @Override
    public Page<User> findPage(UserSearch userSearch) {
        return userRepository.findAll(userSearch.getSpecification(), userSearch.getPageInfo());
    }

    @Override
    /**
     * @see com.car.manage.service.UserService#findById
     */
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void allot(Long id, Long[] roleIds) {
        User user = userRepository.findOne(id);
        if (roleIds != null) {
            user.setRoleList(Stream.of(roleIds).map(Role::new).collect(Collectors.toList()));
        }
        userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsernameAndPasswordAndEnabled(username, password, true);
        return user;
    }

    @Override
    public void copy(Object idcard, Object no) {
        User user1 = userRepository.findByUsernameAndEnabled(no.toString(), true);
        if (user1 == null) {
            User user = new User();
            user.setPassword(CryptographyUtil.md5(((String) idcard).substring(((String) idcard).length() -
                    Constants.PAGE_SIZE, ((String) idcard).length()), Constants.SALT));
            user.setUsername(no.toString());
            user.setSymbol(User.symbol.driver);
            userRepository.save(user);
        }
    }

    @Override
    public User findByPhone(String telephone) {
        return userRepository.findByUsernameAndEnabled(telephone, Boolean.TRUE);
    }

}
