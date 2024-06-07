package com.manage.practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IteratorExample {
	public static void main(String[] args) {
		//List迭代器应用
		 ArrayList list = new ArrayList();
		 list.add("a");
		 list.add("b");
		 list.add("c");
		 for (Iterator iter = list.iterator(); iter.hasNext();) {
		  String str = (String)iter.next();
		  System.out.println(str);
		 }
		 //while循环
		 Iterator iter = list.iterator();
		 while(iter.hasNext()){
		  String str = (String) iter.next();
		  System.out.println(str);
		 }
		 
		 //Map迭代器应用
		 Map<String, String> map = new HashMap();
		 map.put("1", "a");
		 map.put("2", "b");
		 map.put("3", "c");
		 
		 Set set = map.keySet();   
		 Iterator it = set.iterator();
		//while循环
		 while(it.hasNext()){
			   Object key=it.next();   
		   if(map.containsKey(key)){
			   String mapValue = map.get(key);
			   System.out.println(mapValue);
		   }  
		 }
	}
}
