package com.manage.exception;

class UserDefinedExceptionDemo {
	public static void main(String[] arg) {
		arg = new String[] { "-1", "20" };
		ExceptionClass obj = new ExceptionClass(Integer.parseInt(arg[0]));
	}
}
