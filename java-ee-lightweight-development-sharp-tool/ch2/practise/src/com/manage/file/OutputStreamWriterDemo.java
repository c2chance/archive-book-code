package com.manage.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {
	public static void main(String[] args) {
		String str = "银魂";
		try {
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream(new File("e:\\practise\\test.txt")));
			osw.write(str, 0, str.length());
			osw.flush();
			osw.close();
			System.out.println("文件写入成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
