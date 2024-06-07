package com.shop.springcloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.ribbon.proxy.annotation.Http.HttpMethod;

@RestController
public class UserController {
	@Autowired
	private RestTemplate restTemplate;
    /**
     * 根据用户ID获取订单信息
     */
	@GetMapping("/findOrderInfoByUserId/{id}")
	public String findOrderInfoByUserId(@PathVariable String id) {
		// 用户订单ID为1
		int orderId = 1;
//		return this.restTemplate.getForObject("http://localhost:7900/order/" + oid, String.class);
		return this.restTemplate
			.getForObject("http://shop-eureka-order/order/" + orderId, String.class);
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}