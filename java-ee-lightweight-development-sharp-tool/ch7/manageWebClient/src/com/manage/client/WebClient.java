package com.manage.client;

import com.manage.service.WebServiceImpl;
import com.manage.service.WebServiceImplService;

public class WebClient {
	public static void main(String[] args) {
		// 创建程序使用的实例
		WebServiceImplService factory = new WebServiceImplService();
		// 通过实例调用接口中对应的远程地址 也就是找到相应的接口
		WebServiceImpl wsImpl = factory.getWebServiceImplPort();
		// 通过实例调用接口中的方法
		String resResult = wsImpl.findGame("张三");
		System.out.println("最喜欢的游戏是："+resResult);
	}
}
