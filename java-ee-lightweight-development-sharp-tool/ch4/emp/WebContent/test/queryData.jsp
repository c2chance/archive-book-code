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
<title>查询员工信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	var contextPath='<%=contextPath%>';
	function submitForm() {
		if ($("#userName").val() == "") {
			alert("用户名不能为空");
			return;
		}
		if ($("#userNum").val() == "") {
			alert("工号不能为空");
			return;
		}
		var formParam = $("#form1").serialize();
		$.ajax({
			type : 'post',
			url : contextPath + '/query/queryDataResult.do',
			data : formParam,
			cache : false,
			dataType : 'json',
			success : function(data) {

			}
		});
	}
	function resetForm() {
		document.mainForm.reset();
	}
	function goBack() {
		window.location.href = contextPath + "/index.jsp";
	}
</script>
</head>
<body>
	<form id="form1" name="mainForm"
		action="<%=contextPath%>/import/import.do" method="post">
		<input type="hidden" name="disabled" value="0" />
		<table border="0" align="center" cellpadding="0" cellspacing="1"
			class="tab">
			<tr>
				<th width="80">姓名</th>
				<td width="300"><input id="userName" name="userName"
					type="text" />
				</td>
			</tr>
			<tr>
				<th>工号</th>
				<td width="300"><input id="userNum" name="userNum" type="text" />
				</td>
			</tr>
			<tr>
				<td width="300" colspan="2" style="text-align:center;"><input
					name="" type="button" onClick="submitForm();" class="css1"
					value="查询" /> <input name="" type="button" class="css1"
					onClick="resetForm();" value="取消" /> <input name="" type="button"
					class="css1" onClick="goBack()" value="后退" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>