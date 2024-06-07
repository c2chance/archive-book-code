package com.model.service;

import com.model.entity.Student;

import java.util.List;

public interface StudentService {
	public List<Student> findAll();

	// 添加学生
	public void add(String sname, int cid, String sex, String birthplace);

	// 根据学号查学生
	public Student findInfoById(int id);
}