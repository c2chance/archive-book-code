package com.car.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.car.manage.system.entity.CarBrand;

@Controller
public class ThymeleafController {
	
	@RequestMapping("/car/thymeleaf")
	public String helloFreeMarker(Model model) {
		model.addAttribute("name","Thymeleaf学习");  
	    CarBrand vo = new CarBrand();
	    vo.setCarsBrand("奥拓");
	    vo.setDept("产品部");
	    vo.setDescription("设计");
	    model.addAttribute("carbrand", vo);
		return "car/CarBrand/thymeleaf";
	}

}
