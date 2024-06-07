package com.manage.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	public static void main(String[] args) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(new File("e:\\practise\\test.txt"));
			for (int i = 97; i < 123; i++) {
				fos.write((char) i);
				fos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("文件写入成功");
	}
}
