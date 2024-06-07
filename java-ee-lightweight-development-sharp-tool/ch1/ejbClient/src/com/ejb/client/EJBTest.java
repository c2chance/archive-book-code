package com.ejb.client;

import java.io.IOException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejb.server.ModelEjb;

public class EJBTest {

	public static void main(String[] args) throws NamingException, IOException {
		Properties props = new Properties();
		props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jndi.properties"));
		InitialContext context = new InitialContext(props);
		ModelEjb modelEjb = (ModelEjb) context.lookup("ModelEjbBean/remote");
		String sb = modelEjb.sayHello("程序员");
		System.out.println(sb);
	}

}
