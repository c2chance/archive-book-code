package com.manage.practise;

import java.util.Arrays;

public class ArraySortPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//数组的排序
		int [] a = {18,5,9,3,7,12,10};
		Arrays.sort(a);
		for(int i=0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}

}
