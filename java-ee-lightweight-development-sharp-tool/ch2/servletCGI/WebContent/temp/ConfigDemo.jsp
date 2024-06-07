<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>config内置对象</title>
</head>
<body>
	<!-- 获取config信息-->
	<%
		String name = config.getServletName();
	%>

	<%=name%>
</body>
</html>
