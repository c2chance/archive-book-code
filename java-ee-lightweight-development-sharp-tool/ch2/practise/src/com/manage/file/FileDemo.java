package com.manage.file;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		// 获取当前目录下的文件长度
		File files = new File(".");
		String[] list = files.list();
		for (int i = 0; i < list.length; i++) {
			File file = new File(list[i]);
			System.out.println(list[i] + "长度：" + file.length());
			
		}
		
		// 判断目标是否目录
		File file1 = new File("e:\\practise\\");
		if (file1.isDirectory()) {
			System.out.println("目录地址" + file1.getAbsolutePath());
		} else {
			System.out.println("不是目录");
		}

		// 判断目标是否文件
		File file2 = new File("e:\\practise\\test.txt");
		if (file2.isFile()) {
			System.out.println("文件地址" + file2.getAbsolutePath());
		} else {
			System.out.println("不是文件");
		}

		// 判断文件是否存在
		File file3 = new File("e:" + File.separator + "test");
		if (file3.exists()) {
			System.out.println(file3.getName());
		} else {
			System.out.println("不存在");
		}
	}
}
