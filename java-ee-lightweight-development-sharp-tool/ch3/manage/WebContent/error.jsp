<%@ page contentType="text/html;charset=gbk" language="java"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>Simple jsp page</title>
</head>
<body>
	<h1>error!!!!!!</h1>
	<div><a href="<%=basePath%>/login.jsp">��½</a></div>
	<div><a href="<%=basePath%>/index.jsp">��ҳ</a></div>
</body>
</html>