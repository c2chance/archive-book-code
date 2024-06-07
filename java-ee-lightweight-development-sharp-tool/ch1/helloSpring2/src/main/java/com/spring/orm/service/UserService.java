package com.spring.orm.service;

import java.util.List;

import com.spring.orm.entity.User;

public interface UserService {
	List<User> selectUsers();//��ѯ����
    int addUsers(User user);//����
    int deleteUser(long id);//ɾ��
    int updateUser(User user);//����
    public User selectOneUser(long id);//����id��ѯ
}
