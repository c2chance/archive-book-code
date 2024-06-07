package com.manage.practise;

import java.util.ArrayList;

public class GatherDifferencePractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apple[] a = new Apple[10];
		Orange[] o = new Orange[10];
		
		Apple apple = new Apple();
		Orange orange = new Orange();
		ArrayList list = new ArrayList();
		list.add(apple);
		list.add(orange);
		
		Apple app = (Apple) list.get(0);
		Orange ora = (Orange) list.get(1);
	}

}
