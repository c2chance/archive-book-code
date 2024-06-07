package com.practice.annotation;

public class ZhangSanStudent extends Student {
	@Override
	public void studentAge() {
		System.out.println("张三的年龄是"+ 20);
	}
	
	public static void main(String[] args) {
		Student zhangSanStudnet = new ZhangSanStudent();
		zhangSanStudnet.studentAge();
	}
}
