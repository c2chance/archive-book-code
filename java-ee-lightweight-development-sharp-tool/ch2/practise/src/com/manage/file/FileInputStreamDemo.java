package com.manage.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		// 读取文件中的内容
		File file = new File("e:\\practise\\test.txt");
		byte[] bt = new byte[(byte) file.length()];
		try {
			FileInputStream fis = new FileInputStream(file);
			fis.read(bt);
			for (int i = 0; i < bt.length; i++) {
				System.out.print((char) bt[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}