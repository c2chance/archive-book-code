package com.swagger.swaggerui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wb")
public class SwaggeruiApplication
{

   public static void main( String[] args )
   {
      SpringApplication.run( SwaggeruiApplication.class, args );
   }

}
