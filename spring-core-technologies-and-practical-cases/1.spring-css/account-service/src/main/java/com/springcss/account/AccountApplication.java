package com.springcss.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	@Autowired
	SpringCssConfig springCssConfig;
	
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println(springCssConfig.getPoints());
    }
}
