package com.model.dao;

import com.model.entity.Student;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

	public List<Student> findAll();// 查找所有学生

	public void add(@Param("sname") String sname, @Param("cid") int cid, @Param("sex") String sex,
			@Param("birthplace") String birthplace);// 添加学生

	public Student findInfoById(int id);// 根据学号查学生

}