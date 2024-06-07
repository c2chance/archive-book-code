package com.aop.service;

import org.springframework.stereotype.Service;

@Service
public class AspectService {

    public String sayHi(String name)  
    {  
        System.out.println("方法：sayHi执行中...");  
        return"Hello, " + name;  
    }  

    public void excuteException()  
    {  
        System.out.println("方法：excuteException执行中...");  
        int n = 1;
        if(n > 0) {
            throw new RuntimeException("数据异常");
        }
    } 
    
    
}