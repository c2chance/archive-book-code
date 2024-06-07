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
<title>附件上传</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
.progress{z-index: 2000} 
.mask{position: fixed;top: 0;right: 0;bottom: 0;left: 0; z-index: 1000; background-color: #2F2F2F} 
</style>
<script type="text/javascript">
var contextPath='<%=contextPath%>';
function goBack(){
	window.location.href=contextPath+"/import/importExcel.do";
}

</script>
</head>
<body>
	<c:if test="${not empty success}">
		<c:if test="${not empty t1}">
			<center>
				员工信息共上传${t1 }条记录<BR>
			</center>
		</c:if>
	</c:if>
	<c:if test="${not empty error}">
		<center>
			失败<BR>
		</center>
	</c:if>
	<center>	
			&nbsp;&nbsp;&nbsp;<input name="" type="button"
			class="wb1" onClick="goBack();" value="后 退" />
	</center>
<div id="maskOfProgressImage" class="wb2" style="display:none"></div> 
</body>
</html>
