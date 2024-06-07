package com.manage.xml;

public class Student {

	String name;
	String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + "]";
	}

}
