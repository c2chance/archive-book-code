<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>application内置对象</title>
</head>
<body>
	<!-- 获取application信息-->
	<%
		out.println(application.getMajorVersion());
		out.println(application.getMinorVersion());
		out.println(application.getServerInfo());
		out.println(application.getContextPath());
		out.println(application.getRealPath("/"));

		String test = application.getContextPath();
	%>

	<%="测试=" + test%>
</body>
</html>
