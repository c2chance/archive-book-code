package com.manage.practise;

import java.util.HashMap;
import java.util.Vector;

public class GatherHashMapPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apple app = new Apple();
		app.setApplePrice(5);
		app.setAppleNumber(10);
		HashMap hm = new HashMap();
		hm.put(1, "张三");
		hm.put(2, "李四");
		hm.put(3, "王五");
		hm.put(app.getApplePrice(), app.getAppleNumber());
		hm.remove(3);
		System.out.println(hm);
	}

}
