package com.car.manage;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * main.
 **/
@SpringBootApplication(scanBasePackages = "com.car.manage")
@EnableTransactionManagement
@ServletComponentScan
public class Application {
/*    *
     * main.
     *
     * @param args args.
     **/
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addInitializers(new CarApplicationContext());
        springApplication.run(args);
    }

/*    *
     * create session factory.
     *
     * @param emf entity manager factory
     * @return session factory
     **/
    @Bean
    public SessionFactory sessionFactory(EntityManagerFactory emf) {
        if (emf.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }

        return emf.unwrap(SessionFactory.class);
    }
}
