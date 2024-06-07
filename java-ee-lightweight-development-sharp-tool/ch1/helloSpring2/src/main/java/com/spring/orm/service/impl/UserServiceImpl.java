package com.spring.orm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.dao.UserDAO;
import com.spring.orm.entity.User;
import com.spring.orm.service.UserService;

//标注本类是一个Service组件
@Service
//在Service层启动事务
@Transactional
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDAO userDAO;

@Override
public List<User> selectUsers() {
	 return userDAO.selectAll();
}

@Override
public int addUsers(User user) {
	return userDAO.insert(user);
}

@Override
public int deleteUser(long id) {
	return userDAO.deleteByPrimaryKey(id);
}

@Override
public int updateUser(User user) {
	return userDAO.updateByPrimaryKey(user);
}

@Override
public User selectOneUser(long id) {
	 return userDAO.selectByPrimaryKey(id);
}


}
