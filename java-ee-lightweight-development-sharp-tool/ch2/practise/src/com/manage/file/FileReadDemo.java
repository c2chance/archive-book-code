package com.manage.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadDemo {
	public static void main(String args[]) throws IOException {
		File file = new File("e:\\practise\\test.txt");
		// 创建文件
		file.createNewFile();
		// 创建FileWriter
		FileWriter writer = new FileWriter(file);
		// 向文件写入内容
		writer.write("刘备");
		writer.flush();
		writer.close();
		// 创建FileReader
		FileReader fr = new FileReader(file);
		char[] a = new char[20];
		// 读取数组中的内容
		fr.read(a);
		for (char c : a)
			// 输出
			System.out.print(c);
		fr.close();
	}
}