package com.manage.client;

import com.manage.service.WebServiceImpl;
import com.manage.service.WebServiceImplService;

public class WebClient {
	public static void main(String[] args) {
		// ��������ʹ�õ�ʵ��
		WebServiceImplService factory = new WebServiceImplService();
		// ͨ��ʵ�����ýӿ��ж�Ӧ��Զ�̵�ַ Ҳ�����ҵ���Ӧ�Ľӿ�
		WebServiceImpl wsImpl = factory.getWebServiceImplPort();
		// ͨ��ʵ�����ýӿ��еķ���
		String resResult = wsImpl.findGame("����");
		System.out.println("��ϲ������Ϸ�ǣ�"+resResult);
	}
}
