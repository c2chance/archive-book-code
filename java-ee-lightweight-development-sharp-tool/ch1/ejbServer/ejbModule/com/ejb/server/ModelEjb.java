package com.ejb.server;

import javax.ejb.Remote;

@Remote
public interface ModelEjb {
	public String sayHello(String name);
}
