<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>全局配置</title>
</head>
<body>
	  <form action="cgi-bin/hello.exe" method="get">
	     姓名： <input type="text" name="name" >
	     年龄：  <input type="text" name="age" ><br>
	       <input type="submit" value="提交">
	  </form>
	  
	  <form action="userRegister" method="get">
	     姓名： <input type="text" name="name" >
	     年龄：  <input type="text" name="age" ><br>
	       <input type="submit" value="提交Servlet Get到服务器">
	  </form>	  
	  
	  <form action="userRegister" method="post">
	     姓名： <input type="text" name="name" >
	     年龄：  <input type="text" name="age" ><br>
	       <input type="submit" value="提交Servlet Post到服务器">
	  </form>		  
	  
</body>
</html>