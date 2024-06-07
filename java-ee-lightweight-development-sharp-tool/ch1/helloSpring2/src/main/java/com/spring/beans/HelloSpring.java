package com.spring.beans;

public class HelloSpring {
	
	private String name;
	private int studentId;
	
	public void setName(String name){
		System.out.println("setName:"+name);
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void sayHello(){
		System.out.println("hello:"+name);
	}
	public HelloSpring(){
		System.out.println("HelloSpring 你好春天！");
	}
}
