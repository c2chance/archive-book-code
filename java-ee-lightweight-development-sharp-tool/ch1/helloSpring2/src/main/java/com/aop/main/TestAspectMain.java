package com.aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.service.AspectService;

public class TestAspectMain {

    public static void main(String[] args) {

        // ClassPathXmlApplicationContext默认是加载src目录下的xml文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AspectService aservice = context.getBean(AspectService.class);  
        System.out.println("\n=普通调用=\n");  
        
        aservice.sayHi("wb");
        
        System.out.println("\n=异常调用=\n");  
        
        aservice.excuteException();

        System.out.println("\n===\n");  
    }

}