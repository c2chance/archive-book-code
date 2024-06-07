<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
%>
<html>
<head>
<base>

<title>员工信息系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
</script>
</head>

<body>
	<a href="<%=contextPath%>/import/importExcel.do">上传员工信息</a>
	<a href="<%=contextPath%>/query/queryData.do">查询员工信息</a>
</body>
</html>
