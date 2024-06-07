<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>session内置对象</title>
</head>
<body>
	<!-- 初始化session信息-->
	<%
		session.setAttribute("name", "路飞");
		session.setMaxInactiveInterval(1500);
	%>
</body>
</html>
