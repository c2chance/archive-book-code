package com.example.pojo;

import java.io.Serializable;

public class EmpBean implements Serializable {
	private String name;

	public EmpBean() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
