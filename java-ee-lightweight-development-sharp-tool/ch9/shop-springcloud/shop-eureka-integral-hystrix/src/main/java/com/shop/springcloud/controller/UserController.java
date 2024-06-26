package com.shop.springcloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
/**
 * 用户控制器类
 */
@RestController
public class UserController {
	@Autowired
	private RestTemplate restTemplate;
    /**
     * 查找与用户相关的订单
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     */
	@GetMapping("/findOrderInfoByUserId/{id}")
	@HystrixCommand(fallbackMethod = "errorInfo")
	public String findOrderInfoByUserId(@PathVariable String id) {
		// 假设用户只有一个订单，并且订单id为1
		int orderId = 1;
		return this.restTemplate
			.getForObject("http://shop-eureka-order/order/" + orderId, 
					String.class);
	}
	
	
	
    /**
     * 查找与用户相关的订单
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     */
	@GetMapping("/findOrderIntegralByUserId/{id}")
	@HystrixCommand(fallbackMethod = "errorInfo")
	public String findOrderIntegralByUserId(@PathVariable String id) {
		// 假设用户只有一个订单，并且订单id为1
		int orderId = 1;
		return this.restTemplate
			.getForObject("http://shop-eureka-order/orderIntegral/" + orderId, 
					String.class);
	}
	
	
	
	
	
	/**
	 * 返回信息方法
	 */
	public String errorInfo(@PathVariable String id){
		return "服务器停止运行了！";
	} 
}