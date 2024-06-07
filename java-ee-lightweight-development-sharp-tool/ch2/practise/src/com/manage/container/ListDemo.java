package com.manage.container;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*		List list = new ArrayList();
		list.add("赵玲栎");
		list.add("陈婉如");
		list.add("李杭西");

		System.out.println(list);*/
		
/*		List list = new Vector();
		list.add("赵玲栎");
		list.add("陈婉如");
		list.add("李杭西");*/

		//System.out.println(list);
		
		
		
/*		Stack sc = new Stack();
		sc.push("赵玲栎");
		sc.push("陈婉如");
		sc.push("李杭西");*/

		//System.out.println(sc);
		//System.out.println(sc.peek());
		
/*		代码解析：Stack是一个后进先出的堆栈。
		用法跟List是大同小异的，只是方法不同罢了。
		比如添加元素由add变成了push方法。
		但Stack既然是堆栈，那么肯定会有堆栈相关的方法。
		在输出的结果中，我们看到第一行输出的三个名字跟List输出的并无大致。
		但是使用peek就可以轻松的输出栈顶元素，这个是List没有的方法。*/
		
		
		
		
		List list = new LinkedList();
		list.add("赵奢");
		list.add("廉颇");
		list.add("李牧");
		list.remove("李牧");

		System.out.println(list);
		
		
		
		
		

	}

}
