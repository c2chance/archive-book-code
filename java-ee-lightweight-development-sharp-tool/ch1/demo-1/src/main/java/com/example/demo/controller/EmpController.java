package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

	@RequestMapping("/findEmpName")
	public String findEmpName(){
		return "张三";
	}
}
