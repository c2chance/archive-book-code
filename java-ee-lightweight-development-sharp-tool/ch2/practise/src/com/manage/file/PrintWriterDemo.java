package com.manage.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) {
		PrintWriter pw = null;
		String name = "����";
		int age = 50;
		float score = 90f;
		char sex = '��';
		try {
			pw = new PrintWriter(new FileWriter(new File(
					"e:\\practise\\test.txt")), true);
			pw.printf("������%s ���䣺%d �Ա�%s ������%5.2f ", name, age, sex, score);
			pw.println("�������");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}
}