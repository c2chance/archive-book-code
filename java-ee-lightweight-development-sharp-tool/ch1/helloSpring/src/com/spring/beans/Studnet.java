package com.spring.beans;

public class Studnet {
	
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
	public Studnet(){
	}
	
/*	public Studnet(String name){
		this.name = name;
	}*/

}
