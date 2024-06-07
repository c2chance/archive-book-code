package com.manage.service;

import javax.jws.WebMethod;

@javax.jws.WebService
public interface WebService {
	@WebMethod
	String findGame(String name);
}
