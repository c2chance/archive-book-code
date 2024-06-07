<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>pageContext内置对象</title>
</head>
<body>
	<!-- 获取pageContext信息-->
	<%
		pageContext.setAttribute("sh", "香克斯");
		String name = (String) pageContext.getAttribute("sh");
		Object exist = pageContext.findAttribute("sh");
	%>

	<%="姓名=" + name%>
	<%="姓名=" + exist%>
</body>
</html>
