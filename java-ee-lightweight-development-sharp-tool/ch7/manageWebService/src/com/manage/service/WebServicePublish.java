package com.manage.service;

import javax.xml.ws.Endpoint;

public class WebServicePublish {
	public static void main(String[] args) {
		// ����WebService������ַ �ӿ���ø�ҵ����� ��findGame��ѯ��Ϸ
		String address = "http://localhost:8888/WS_Server/findGame";
		// ʹ��Endpoint��������WebService����
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("WebService���񷢲��ɹ���");
	}
}
