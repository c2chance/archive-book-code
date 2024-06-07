package com.wb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //在springboot中加载配置文件
@EnableSwagger2 //加载swagger
public class SwaggerConfig
{

   @Bean
   public Docket api()
   {
      return new Docket( DocumentationType.SWAGGER_2 ).apiInfo( apiInfo() ) // 调用apiInfo方法
            .pathMapping( "/" ) //配置访问路径
            .select().paths( PathSelectors.regex( "/.*" ) ) //匹配路径下的方法
            .build();

   }

   private ApiInfo apiInfo()
   {
      return new ApiInfoBuilder().title( "" ).contact( new Contact( "wb", "", "xxxxxxxxxx@qq.com" ) ).description( "SwaggerUI生成的接口文档" ).version( "1.0" ).build();

   }

}
