package com.manage.thread;

public class ThreadDispatchDemo extends Thread {
	Thread th = null;

	public ThreadDispatchDemo() {
		th = new Thread(this);
		System.out.println("线程th状态是新建");
		System.out.println("线程th状态是已经就绪");
		th.start();
	}

	@Override
	public void run() {
		try {
			System.out.println("线程th状态是正在运行");
			Thread.sleep(5000);
			System.out.println("线程th状态是在睡眠5秒之后，重新运行");
		} catch (InterruptedException e) {
			System.out.println("线程th状态是被终端：" + e.toString());
		}
	}

	public static void main(String[] args) {
		ThreadDispatchDemo td = new ThreadDispatchDemo();
	}
}
