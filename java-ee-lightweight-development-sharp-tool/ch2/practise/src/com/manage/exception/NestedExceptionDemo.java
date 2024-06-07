package com.manage.exception;

class NestedExceptionDemo {
	public void test(String[] args) {
		try {
			int num = Integer.parseInt(args[4]);
			try {
				int numValue = Integer.parseInt(args[0]);
				System.out.println("args[0] + “的平方是 " + numValue * numValue);
			} catch (NumberFormatException nb) {
				System.out.println("不是数字！");
			}
		} catch (ArrayIndexOutOfBoundsException ne) {
			System.out.println("索引越界！");
		}
	}

	public static void main(String[] args) {
		NestedExceptionDemo obj = new NestedExceptionDemo();
		args = new String[] { "xyz", "222" };
		obj.test(args);
	}
}