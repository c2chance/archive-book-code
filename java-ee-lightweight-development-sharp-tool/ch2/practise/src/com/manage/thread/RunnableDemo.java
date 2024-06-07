package com.manage.thread;

public class RunnableDemo implements Runnable {
	public static void main(String[] args) {
		Thread th1 = Thread.currentThread();
		System.out.println("主线程：" + th1.getName());
		RunnableDemo rd = new RunnableDemo();
		new Thread(rd, "第1个子线程").start();
		new Thread(rd, "第2个子线程").start();
		Thread th2 = new Thread(rd);
		th2.start();
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
