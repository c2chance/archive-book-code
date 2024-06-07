<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>session内置对象</title>
</head>
<body>
	<!-- 获取session信息-->
	<%
		out.println(session.getId());
		out.println(session.getAttribute("name"));
		out.println(session.getCreationTime());
		out.println(session.getLastAccessedTime());
		out.println(session.getMaxInactiveInterval());
	%>
</body>
</html>
