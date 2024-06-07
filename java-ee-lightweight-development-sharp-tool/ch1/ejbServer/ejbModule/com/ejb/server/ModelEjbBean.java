package com.ejb.server;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote
public class ModelEjbBean implements ModelEjb {

	@Override
	public String sayHello(String name) {
		return name + "你好！这是第1个EJB项目";
	}

}
