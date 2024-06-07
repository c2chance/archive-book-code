package com.manage.exception;

public class ArithmeticExceptionDemo {
	public static void main(String[] args) {
		try {
			int result = 8 / 0;
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("发生异常：" + e.toString());
			e.printStackTrace();
		}
	}
}
