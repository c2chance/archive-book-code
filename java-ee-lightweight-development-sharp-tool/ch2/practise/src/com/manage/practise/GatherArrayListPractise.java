package com.manage.practise;

import java.util.ArrayList;

public class GatherArrayListPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		Apple apple = new Apple();
		ArrayList list = new ArrayList();
		for(int i=0; i<100; i++){
			list.add(apple);
		}
		System.out.println(list.size());
	}

}
