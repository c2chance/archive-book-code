package com.manage.bean;

public abstract class Car {
	public abstract void price();

	public static void main(String[] args) {
		Car BMW = new BMW();
		Car Benz = new Benz();
		BMW.price();
		Benz.price();
	}
}

class BMW extends Car {
	@Override
	public void price() {
		System.out.println("宝马88万");
	}
}

class Benz extends Car {
	@Override
	public void price() {
		System.out.println("奔驰86万");
	}
}
