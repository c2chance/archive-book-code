package com.wb.server;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController 
@Api(value = "/", description = "API接口方法")
public class MyMethodAPI
{
   @RequestMapping(value = "/getEmpId", method = RequestMethod.GET) 
   @ApiOperation(value = "获得员工信息", httpMethod = "GET")
   public String getEmpId( HttpServletResponse response )
   { 
      return "获得员工Id成功";
   }

   @RequestMapping(value = "/getEmpName", method = RequestMethod.POST) 
   @ApiOperation(value = "获得员工姓名", httpMethod = "POST")
   public String getEmpName( HttpServletResponse response )
   {
	  //String empVO = emp.getEmpVOByEmpId();
      //return "获得员工姓名成功，他的名字是："+ empVO.getName();
		String empName = "达芬奇";
	    return "获得员工姓名成功，他的名字是："+ empName;
   }

}
