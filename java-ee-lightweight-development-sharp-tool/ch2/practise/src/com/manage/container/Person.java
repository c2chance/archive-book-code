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
			return -1; // ������ obj1С��obj2
		} else if (this.age > p.age) {
			return 1; // ������ obj1����obj2
		} else {
			return 0; // ���
		}
	}
}
