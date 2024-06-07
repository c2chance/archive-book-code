package com.manage.service;

import javax.xml.ws.Endpoint;

public class WebServicePublish {
	public static void main(String[] args) {
		// 定义WebService发布地址 接口最好跟业务相关 如findGame查询游戏
		String address = "http://localhost:8888/WS_Server/findGame";
		// 使用Endpoint类来发布WebService服务
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("WebService服务发布成功！");
	}
}
