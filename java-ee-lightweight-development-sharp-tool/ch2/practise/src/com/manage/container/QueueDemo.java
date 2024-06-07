package com.manage.container;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue qu = new LinkedList();
		qu.add("赵奢");
		qu.add("廉颇");
		qu.add("李牧");
		System.out.println(qu.poll());
		System.out.println(qu);
	}

}
