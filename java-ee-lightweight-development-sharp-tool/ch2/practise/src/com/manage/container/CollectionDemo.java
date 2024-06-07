package com.manage.container;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
	public static void main(String[] args) {
		Collection c1 = new ArrayList();
		c1.add("土豆");
		c1.add("菜花");
		c1.add("黄瓜");
		System.out.println(c1.size());
	}
}