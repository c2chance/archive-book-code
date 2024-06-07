package com.manage.test;

public class Test2 {
	int a;
	double b;
	boolean c;
	char d;
	float f;
	byte e;
	long h;
	short j;

	public static void main(String args[]) {
		Test2 a = new Test2();
		System.out.println("整型的默认值是：" + a.a);
		System.out.println("双精度浮点型的默认值是：" + a.b);
		System.out.println("布尔型的默认值是：" + a.c);
		System.out.println("字符型的默认值是：" + a.d);
		System.out.println("byte的默认值是：" + a.e);
		System.out.println("单精度浮点型的默认值是：" + a.f);
		System.out.println("短整型的默认值是：" + a.j);
		System.out.println("长整型的默认值是：" + a.h);
	}
}