package com.manage.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) {
		PrintWriter pw = null;
		String name = "刘备";
		int age = 50;
		float score = 90f;
		char sex = '男';
		try {
			pw = new PrintWriter(new FileWriter(new File(
					"e:\\practise\\test.txt")), true);
			pw.printf("姓名：%s 年龄：%d 性别：%s 智力：%5.2f ", name, age, sex, score);
			pw.println("蜀国君主");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}