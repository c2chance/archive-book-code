<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>page内置对象</title>
</head>
<body>
	<!-- 获取page信息-->
	<%	
	String pageDemo = page.toString();
	int hashCode = page.hashCode();
	%>

	<%=pageDemo%>
	<%=hashCode%>
</body>
</html>
