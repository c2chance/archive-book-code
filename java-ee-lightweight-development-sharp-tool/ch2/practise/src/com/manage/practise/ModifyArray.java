package com.manage.practise;

import java.util.Arrays;
import java.util.List;

public class ModifyArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   int b [] = {1,2,3,4,5};
		   b[4] = 888;
			 for(int i=0; i<b.length; i++){
				System.out.println(b[i]);
			}
	
				String[] sb = { "我是", "菜鸟" };
				// 转换成固定长度的集合
				List<String> list = Arrays.asList(sb);
				list.set(1, "高手");
				for (String st : list) {
					System.out.print(st);
				}

	}
}