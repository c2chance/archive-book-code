<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	errorPage="ExceptionDemo.jsp"%>
<html>
<head>
<title>exception内置对象</title>
</head>
<body>
	<!-- 制造错误信息-->
	<%
		String test[] = { "a", "b", "c" };
		out.println(test[8]);
	%>
</body>
</html>
