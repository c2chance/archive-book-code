package com.manage.exception;

class ArraySizeException extends NegativeArraySizeException {
	ArraySizeException() {
		super("数组不正确！");
	}
}
