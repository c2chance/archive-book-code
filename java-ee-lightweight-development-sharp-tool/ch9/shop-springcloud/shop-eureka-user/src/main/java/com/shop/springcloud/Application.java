package com.shop.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {
    @RequestMapping("/hello")
    public String hello() {
        return "test";
    }
 // RestTemplate用于访问Rest服务，提供了多种HTTP方法的调用。
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}