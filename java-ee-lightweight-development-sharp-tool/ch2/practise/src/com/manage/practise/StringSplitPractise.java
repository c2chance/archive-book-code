package com.manage.practise;

public class StringSplitPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//拆分字符串
		String myName = "张三啊";
		String[] newName = myName.split("三");
		System.out.println(newName[0]);
		System.out.println(newName[1]);
	}

}
