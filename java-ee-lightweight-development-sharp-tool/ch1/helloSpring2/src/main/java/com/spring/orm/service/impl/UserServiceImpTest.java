package com.spring.orm.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.orm.entity.User;
import com.spring.orm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring_mybatis.xml"})
public class UserServiceImpTest {
	
	@Autowired
	private UserService userService;
	@Test
	public void selectUsers() {
		List<User> users = userService.selectUsers();
		users.forEach(user -> System.out.println(user.getAccount()));
	}
	@Test
	public void selectOneUser() {
		//User user = userService.selectOneUser(2);
		//System.out.println(user);
	}

}
