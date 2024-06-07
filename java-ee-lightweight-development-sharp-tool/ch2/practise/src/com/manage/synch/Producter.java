package com.manage.synch;

public class Producter implements Runnable {
	private Saleman saleman;

	public Producter(Saleman saleman) {
		this.saleman = saleman;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			saleman.addProduct(new Product());
		}
	}
}
