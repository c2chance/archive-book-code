package com.wb.bk;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @RestController //告诉@ComponentScan ， 我是需要被扫描的类
@Api(value = "/", description = "这是我全部的get方法")
public class MtMethod
{

   @RequestMapping(value = "/getcookies", method = RequestMethod.GET) //配置访问方法和路径
   @ApiOperation(value = "通过这个方法可以获得cookies", httpMethod = "GET")
   public String getCookies( HttpServletResponse response )
   {
      //HttpServletRequest 装请求信息的类,从客户端带着信息来server
      //HttpServletResponse 装响应信息的类， 从server端带着信息回到客户端

      Cookie cookie = new Cookie( "login", "true" ); //设定cookie值
      response.addCookie( cookie );
      return "恭喜你获得cookies成功";
   }

   /*
   开发一个需要携带参数才能访问的get请求
   第一种实现方式： url: key=value&key=value
   我们来模拟获取商品列表
    */
   @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
   @ApiOperation(value = "通过这个方法可以携带cookie，参数去访问get方法", httpMethod = "GET")
   public Map< String, Integer > getList( HttpServletRequest request, @RequestParam Integer start, @RequestParam Integer end )
   {

      Cookie[] cookies = request.getCookies();
      /*HttpServletRequest里有一个方法叫request.getCookies，此方法可以返回cookie，注意cookie是键值对，所以是数组
      需要通过一个数组来存储它         */

      if ( Objects.isNull( cookies ) )
      {
         System.out.println( "判断结果：你需要携带cookies信息来" );
         ; //判断返回的数组cookies是不是为空
      }

      for ( Cookie cookie : cookies )
      {
         if ( cookie.getName().equals( "login" ) && cookie.getValue().equals( "true" ) )
         {
            System.out.println( "恭喜你访问成功" ); //对cookies信息做一个判断，如果判断ok，则表示cookies里的确是有信息
         }
      }
      //商品列表返回的是一个Map， 有一个商品名称，有一个价格
      //@RequestParam，此注解设置开始位置和结束位置
      //真实项目中需要拿start和end到数据库中取值，此处模拟以下商品
      Map< String, Integer > myList = new HashMap<>(); //模拟商品
      myList.put( "Shoes", 400 );
      myList.put( "T-shirt", 200 );
      myList.put( "Doll", 500 );

      return myList;
   }

   @RequestMapping(value = "/getName", method = RequestMethod.GET) //配置访问方法和路径
   @ApiOperation(value = "通过这个方法可以获得姓名", httpMethod = "GET")
   public String getName( HttpServletResponse response )
   {
      //HttpServletRequest 装请求信息的类,从客户端带着信息来server
      //HttpServletResponse 装响应信息的类， 从server端带着信息回到客户端

      Cookie cookie = new Cookie( "login", "true" ); //设定cookie值
      response.addCookie( cookie );
      return "恭喜你获得姓名";
   }

}
