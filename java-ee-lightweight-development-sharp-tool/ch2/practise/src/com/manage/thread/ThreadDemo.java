package com.manage.thread;

public class ThreadDemo extends Thread {
	public static void main(String[] args) {
		Thread th = Thread.currentThread();
		System.out.println("主线程：" + th.getName());
		ThreadDemo td = new ThreadDemo();
		td.start();
	}

	@Override
	public void run() {
		System.out.println("子线程：" + this.getName());
	}
}
