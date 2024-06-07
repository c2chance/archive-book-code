package com.manage.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LifeListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// 项目停止运行
		System.out.println("项目运行停止");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// 项目开始运行
		System.out.println("项目开始运行");
	}

}
