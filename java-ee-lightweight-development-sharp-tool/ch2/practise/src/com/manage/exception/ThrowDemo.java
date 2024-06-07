package com.manage.exception;

public class ThrowDemo {
	public static void main(String[] args) {
		try {
			throwChecked(1);
		} catch (Exception e) {
			System.out.println("上层处理：" + e.getMessage());
		}
		throwRuntime(1);
	}

	public static void throwChecked(int a) throws Exception {
		if (a > 0) {
			throw new RuntimeException("第一种异常");
		}
	}

	public static void throwRuntime(int a) {
		if (a > 0) {
			throw new RuntimeException("第二种异常");
		}
	}
}
