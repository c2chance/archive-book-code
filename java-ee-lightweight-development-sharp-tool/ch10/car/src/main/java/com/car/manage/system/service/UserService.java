package com.car.manage.system.service;

import com.car.manage.system.entity.User;
import com.car.manage.system.search.UserSearch;
import org.springframework.data.domain.Page;

/**
 * 后台用户服务类.
 */
public interface UserService {
    /**
     * 获取所有用户信息.
     *
     * @param userSearch 查询条件
     * @return 用戶集合
     */
    Page<User> findAll(UserSearch userSearch);

    /**
     * 新增用户.
     *
     * @param user 用戶对象.
     */
    void create(User user);

    /**
     * 注册用户.
     *
     * @param user 用戶对象.
     * @return user
     */
    User save(User user);

    /**
     * 更新用户.
     *
     * @param user 用户对象.
     */
    void update(User user);

    /**
     * 删除用户.
     *
     * @param id 用户id.
     */
    void delete(Long id);

    /**
     * 条件分页查询.
     *
     * @param userSearch userSearch
     * @return List<User>
     */
    Page<User> findPage(UserSearch userSearch);

    /**
     * 检查id不为指定id的名称是否存在.
     *
     * @param id       指定id
     * @param username 名称
     * @return true 如果存在， 否则false
     */
    Boolean isExist(Long id, String username);

    /**
     * 根据user id查询user.
     *
     * @param id user id
     * @return user
     */
    User findById(Long id);

    /**
     * 给user分配权限.
     *
     * @param id   用户id集合
     * @param role 权限id集合
     */
    void allot(Long id, Long[] role);

    /**
     * 查询username是否重复.
     *
     * @param username 用户名
     * @return user
     */
    User findByUsername(String username);

    /**
     * 查询用户是否存在.
     *
     * @param username 用户名
     * @param password 密码
     * @return login
     */
    User login(String username, String password);

    /**
     * copy.
     *
     * @param idcard idcard
     * @param no     no
     */
    void copy(Object idcard, Object no);

    /**
     * 根据手机号查询用户.
     *
     * @param telephone telephone
     * @return user
     */
    User findByPhone(String telephone);

}
