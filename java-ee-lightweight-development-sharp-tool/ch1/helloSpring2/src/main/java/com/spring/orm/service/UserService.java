package com.spring.orm.service;

import java.util.List;

import com.spring.orm.entity.User;

public interface UserService {
	List<User> selectUsers();//查询所有
    int addUsers(User user);//插入
    int deleteUser(long id);//删除
    int updateUser(User user);//更新
    public User selectOneUser(long id);//根据id查询
}
