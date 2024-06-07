package com.spring.beans;

public class HelloSpring2 {
	
	private String name;
	private int studentId;
	
	public void setName(String name){
		System.out.println("setName:"+name);
		this.name=name;
	}
	public void sayHello(){
		System.out.println("hello:"+name);
	}
	public HelloSpring2(){
		System.out.println("HelloSpring Constructor...");
	}
}
