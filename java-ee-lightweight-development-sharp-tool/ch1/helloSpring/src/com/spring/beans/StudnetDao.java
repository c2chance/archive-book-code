package com.spring.beans;

public class StudnetDao {
	
	private String name;
	private int studentId;
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void sayHello(){
		System.out.println("hello:"+name);
	}
	public StudnetDao(String name){
		this.name = name;
	}
}
