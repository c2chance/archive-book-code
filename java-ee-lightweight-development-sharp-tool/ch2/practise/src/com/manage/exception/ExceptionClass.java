package com.manage.exception;

class ExceptionClass {
	ExceptionClass(int fun) {
		try {
			if (fun < 0) {
				throw new ArraySizeException();
			}
		} catch (ArraySizeException e) {
			System.out.println(e);
		}
	}

}
