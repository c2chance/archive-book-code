<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>request内置对象</title>
</head>
<body>
	<!-- 使用request对象接收参数 -->
	<%
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		out.println("用户名：" + userName);
	%>
</body>
</html>
