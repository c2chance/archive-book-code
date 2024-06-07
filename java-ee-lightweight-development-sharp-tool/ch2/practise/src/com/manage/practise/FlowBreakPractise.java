package com.manage.practise;

public class FlowBreakPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//continue跳出当次循环
		for(int i=0; i < 5; i++){
			if(i == 3){
				continue;
			}
			System.out.println(i);
		}
	}

}
