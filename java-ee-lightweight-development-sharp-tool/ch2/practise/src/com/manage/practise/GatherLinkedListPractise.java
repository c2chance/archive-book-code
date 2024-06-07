package com.manage.practise;

import java.util.Iterator;
import java.util.LinkedList;

public class GatherLinkedListPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apple apple1 = new Apple();
		apple1.setApplePrice(10);
		apple1.setAppleNumber(100);
		Apple apple2 = new Apple();
		apple2.setApplePrice(5);
		apple2.setAppleNumber(200);
		
		LinkedList lin = new LinkedList();
		lin.add(apple1);
		lin.add(apple2);

		
		Iterator it = lin.iterator();
		while(it.hasNext()) {
			Apple app = (Apple) it.next();
			if(app.getApplePrice()== 10){
				lin.remove(app);
			}
		}
		
		Apple appResult = (Apple) lin.get(0);
		System.out.println(appResult.getAppleNumber());
		System.out.println(appResult.getApplePrice());
	}

}
