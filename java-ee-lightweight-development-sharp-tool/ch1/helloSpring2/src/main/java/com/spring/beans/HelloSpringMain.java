package com.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringMain {

	public static void main(String[] args) {

		// 创建HelloWorld的一个对象，为name属性赋值
		HelloSpring helloSpring = new HelloSpring();
		helloSpring.setName("test");
		// 1、创建Spring的IOC容器对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 2、从IOC容器中获取Bean实例 HelloSpring
		HelloSpring helloSpring2 = (HelloSpring) ctx.getBean("helloSpring");
		// 3、调用sayHello方法
		helloSpring2.sayHello();
	}
}
