package com.manage.container;

public class Person implements Comparable {

	String name;
	int age;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public int compareTo(Object o) {
		Person p = (Person) o;
		if (this.age < p.age) {
			return -1; // 负整数 obj1小于obj2
		} else if (this.age > p.age) {
			return 1; // 正整数 obj1大于obj2
		} else {
			return 0; // 相等
		}
	}
}
