/*package com.wb.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController //告诉@ComponentScan ， 我是需要被扫描的类
@Api(value = "/", description = "API接口方法")
public class MyMethodAPI2
{

   @RequestMapping(value = "/getEmpId", method = RequestMethod.GET) //配置访问方法和路径
   @ApiOperation(value = "通过这个方法可以获得员工信息", httpMethod = "GET")
   public String getEmpId( HttpServletResponse response )
   {
      //HttpServletRequest 装请求信息的类,从客户端带着信息来server
      //HttpServletResponse 装响应信息的类， 从server端带着信息回到客户端

      Cookie cookie = new Cookie( "login", "true" ); //设定cookie值
      response.addCookie( cookie );
      return "恭喜你获得员工信息成功";
   }

   @RequestMapping(value = "/getEmpName", method = RequestMethod.POST) //配置访问方法和路径
   @ApiOperation(value = "通过这个方法可以获得所有员工姓名", httpMethod = "POST")
   public String getEmpName( HttpServletResponse response )
   {
      //HttpServletRequest 装请求信息的类,从客户端带着信息来server
      //HttpServletResponse 装响应信息的类， 从server端带着信息回到客户端

      Cookie cookie = new Cookie( "login", "true" ); //设定cookie值
      response.addCookie( cookie );
      return "恭喜你获得所有员工姓名";
   }

}
*/