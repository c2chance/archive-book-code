package com.service.Impl;

import com.model.dao.StudentDao;
import com.model.entity.Student;
import com.model.service.StudentService;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    
    // 注入Dao实例 ，否则Dao是NULL值
	@Resource
	private StudentDao studentDao;

	public List<Student> findAll() {
		return studentDao.findAll();
	}

	public void add(String name, int cid, String sex, String address) {

	}

	public Student findInfoById(int id) {
		return studentDao.findInfoById(id);
	}
}