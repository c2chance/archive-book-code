package com.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

	public static void main(String[] args) {

		// 1、创建Spring的IoC容器对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Studnet student = (Studnet) ctx.getBean("studnet");
		System.out.println("姓名："+student.getName());
	}
}
