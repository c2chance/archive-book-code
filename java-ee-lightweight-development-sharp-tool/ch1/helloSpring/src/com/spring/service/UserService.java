package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.repository.UserRepository;

@Service

public class UserService {


	@Autowired
	private UserRepository userRepository;

	public void save() {
		userRepository.save();
	}
}