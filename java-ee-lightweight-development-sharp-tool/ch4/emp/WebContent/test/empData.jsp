<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<jsp:include page="/include/commons.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base>
<title>查询</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
var contextPath='<%=contextPath%>';
	function submitForm() {
		document.mainForm.submit();
	}
	function resetForm() {
		document.mainForm.reset();
	}
	function goBack() {
		window.location.href = contextPath + "/query/queryData.do";
	}
</script>
</head>
<body onload="resetForm()">
	<center>员工信息如下：</center>
	<BR>
	<table border="0" align="center" cellpadding="0" cellspacing="1"
		class="tab">
		<tr>
			<th>工号</th>
			<th>姓名</th>
			<th>手机</th>
			<th>邮箱</th>
			<th>身份证</th>
			<th>创建时间</th>
		</tr>
		<c:if test="${empty empList}">
			<tr>
				<td colspan="12"><center>未找到相关工资信息</center>
				</td>
			</tr>
		</c:if>
		<c:if test="${not empty empList}">
			<c:forEach var="s" items="${empList}">
				<tr>
					<td>${s.userNum}</td>
					<td>${s.userName}</td>
					<td>${s.phone}</td>
					<td>${s.email}</td>
					<td>${s.cardNum}</td>
					<td>${s.createTime}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<center>
		<input name="ht" type="button" class="css2" onClick="goBack();"
			value="后退" />
	</center>
</body>
</html>