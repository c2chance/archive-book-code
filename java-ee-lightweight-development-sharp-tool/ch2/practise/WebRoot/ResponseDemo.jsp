<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>response内置对象</title>
</head>
<body>
	<!-- 使用response实现跳转 -->
	<%
		response.sendRedirect("TargetPage.jsp");
	%>
</body>
</html>
