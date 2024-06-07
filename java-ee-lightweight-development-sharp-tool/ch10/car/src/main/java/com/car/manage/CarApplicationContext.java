package com.car.manage;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class CarApplicationContext implements ApplicationContextInitializer {
     @Override
     public void initialize(ConfigurableApplicationContext applicationContext) {
         System.out.println("CarApplicationContext initialize！");
     }
}