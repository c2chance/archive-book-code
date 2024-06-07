package com.car.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreeMarkerController {
	
	@RequestMapping("/car/freeMarker")
	public String helloFreeMarker(Model model) {
		model.addAttribute("name","FreeMarker学习");  
		return "car/CarBrand/freeMarker";
	}

}
