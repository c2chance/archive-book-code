package com.manage.synch;

public class ShopDemo {
	public static void main(String[] args) {
		Saleman saleman = new Saleman();
		Producter producter = new Producter(saleman);
		Customer customer = new Customer(saleman);

		Thread producterOne = new Thread(producter);
		Thread customerOne = new Thread(customer);
		producterOne.start();
		customerOne.start();
	}
}
