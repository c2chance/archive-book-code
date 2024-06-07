package com.manage.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IteratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * // 新建List集合 List list = new ArrayList(); list.add("赵玲栎");
		 * list.add("陈婉如"); list.add("李杭西");
		 * 
		 * // 使用迭代器遍历List for循环 for (Iterator iter = list.iterator();
		 * iter.hasNext();) { String str = (String) iter.next();
		 * System.out.println(str); }
		 * 
		 * // 使用迭代器遍历List while循环 Iterator iter = list.iterator(); while
		 * (iter.hasNext()) { String str = (String) iter.next();
		 * System.out.println(str); }
		 */

/*		HashMap hm = new HashMap();
		hm.put(1, "宇宙");
		hm.put(2, "银河");
		hm.put(3, "地球");*/

		// keySet遍历
/*		Set set = hm.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			System.out.println("键值：" + key + " 数值：" + hm.get(key));
		}*/

		// entrySet遍历
/*		Iterator iter = hm.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			System.out.println("键值：" + key + " 数值：" + hm.get(key));
		}*/

		
		
		
		
		
		
		// 新建List集合
/*		List list = new ArrayList();
		list.add("赵奢");
		list.add("廉颇");
		list.add("李牧");*/
		// 使用迭代器遍历List for循环
/*		for (Iterator iter = list.iterator(); iter.hasNext();) {
			String str = (String) iter.next();
			System.out.println(str);
		}*/
		// 使用迭代器遍历List while循环
/*		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			String str = (String) iter.next();
			System.out.println(str);
		}*/

		
		
		
		
		
		


		
		
		
		
	}

}
