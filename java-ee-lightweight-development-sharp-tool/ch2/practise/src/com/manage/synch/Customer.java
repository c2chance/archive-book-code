package com.manage.synch;

public class Customer implements Runnable {
	private Saleman saleman;

	public Customer(Saleman saleman) {
		this.saleman = saleman;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			saleman.romoveProduct();
		}
	}
}
