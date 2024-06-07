package com.shop.springcloud.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shop.springcloud.bean.Order;
import com.shop.springcloud.util.RibbonUtil;
@RestController
public class OrderController {
    /**
     * 通过id查询订单
     */
	@GetMapping("/order/{id}")
	public String findOrderById(@PathVariable String id) {
		System.out.println(RibbonUtil.getServicePort());
		Order order = new Order();
		order.setId("1");
		order.setPrice(88.8);
		order.setSku("李白全集");
		order.setAddress("大理古镇");
		order.setName("王波");
		order.setPhone("123456");
		return order.toString();
	}
	
    /**
     * 通过id查询积分
     */
	@GetMapping("/orderIntegral/{id}")
	public String findOrderIntegralById(@PathVariable String id) {
		System.out.println(RibbonUtil.getServicePort());
		Order order = new Order();
		order.setId("1");
		order.setPrice(88.8);
		order.setSku("李白全集");
		order.setAddress("大理古镇");
		order.setName("王波");
		order.setPhone("123456");
		order.setIntegral("100");
		return order.toString();
	}
}