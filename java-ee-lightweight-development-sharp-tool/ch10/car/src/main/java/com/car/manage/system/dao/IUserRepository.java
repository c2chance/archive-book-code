package com.car.manage.system.dao;

import com.car.manage.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 用户访问数据库接口.
 */
public interface IUserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     * 根据用户名查询用户,精确查找.
     *
     * @param userName 用户名
     * @param enabled  删除标识
     * @return 查询的用户
     */
    User findByUsernameAndEnabled(String userName, Boolean enabled);

    /**
     * 查询所有用户.
     *
     * @param enabled enabled
     * @param symbol  标识
     * @return List<User>
     */
    List<User> findByEnabledAndSymbol(Boolean enabled, User.symbol symbol);

    /**
     * 计算id不为指定id的名称的个数.
     *
     * @param id       指定id.
     * @param username 名称.
     * @return id不为指定id的名称的个数.
     */
    @Query("select count(0) from User u where u.id <> :id and u.username = :username and u.enabled=true")
    Long countByName(@Param("id") Long id, @Param("username") String username);


    /**
     * 查询用户是否存在.
     *
     * @param username username
     * @param password password
     * @param enabled  enabled
     * @return user
     */
    User findByUsernameAndPasswordAndEnabled(String username, String password, Boolean enabled);

    /**
     * 根据id查询用户.
     *
     * @param id id
     * @return user
     */
    User findById(Long id);
}
