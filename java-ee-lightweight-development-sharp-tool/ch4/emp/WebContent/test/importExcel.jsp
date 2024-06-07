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
<title>上传员工信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
var contextPath='<%=contextPath%>';
	function submitForm() {
		var str = document.getElementById("t1").value;
		var t1 = str.length == 0;
		if (t1) {
			alert("请上传附件");
			return;
		}
		document.mainForm.submit();
	}
	function resetForm() {
		document.mainForm.reset();
	}

	function goBack() {
		window.location.href = contextPath + "/index.jsp";
	}
</script>
</head>
<body onload="resetForm()">
	<form name="mainForm" action="<%=contextPath%>/import/importAction.do"
		method="post" enctype="multipart/form-data">
		<table border="0" align="center" cellpadding="0" cellspacing="1"
			class="tab">
			<tr>
				<th width="80">人员基本表：</th>
				<td width="300"><input id="t1" name="t1" type="file" /></td>
			</tr>
			<tr>
				<td width="300" colspan="2" style="text-align:center;"><input
					name="tj" type="button" class="css3" value="导入"
					onClick="submitForm();" /><input name="qx" type="button"
					class="css3" value="取消" onClick="resetForm();" /><input
					name="ht" type="button" class="css3" onClick="goBack();" value="后退" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
