package com.manage.reflection;

import java.lang.reflect.Method;

public class InvokeDemo {
	public int add(int param1, int param2) {
		return param1 + param2;
	}

	public String echo(String msg) {
		return "喜欢：" + msg;
	}

	public static void main(String[] args) throws Exception {
		Class<?> classType = InvokeDemo.class;
		Object invokeDemo = classType.newInstance();

		// 第二种方法
		// Object InvokeDemo = classType.getConstructor(new
		// Class[]{}).newInstance(new Object[]{});

		// 为add方法赋予数据类型
		Method addMethod = classType.getMethod("add", new Class[] { int.class,
				int.class });
		// 调用InvokeDemo类的add方法，并且赋予具体的数值。
		Object result = addMethod.invoke(invokeDemo, new Object[] { 100,
				new Integer(200) });
		// 输出加法运算的结果
		System.out.println((Integer) result);

		// 调用InvokeDemo类的echo方法，并且赋予具体的数值。
		Method echoMethod = classType.getMethod("echo",
				new Class[] { String.class });
		result = echoMethod.invoke(invokeDemo, new Object[] { "可乐" });
		// 输出字符串的结果
		System.out.println((String) result);
	}
}
