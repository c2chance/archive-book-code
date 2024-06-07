package com.manage.bean;

public class Student {
	private String id;
	private String name;
	private String sex;
	private int age;
	private float score;

	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float a, float b, float c) {
		this.score = a + b + c;
	}
}
