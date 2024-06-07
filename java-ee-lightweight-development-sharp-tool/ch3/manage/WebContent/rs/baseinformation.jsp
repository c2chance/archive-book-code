<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Form - jQuery EasyUI Demo</title>
	<style type="text/css">
		label{
			width:120px;
			display:block;
		}
	</style>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/demo.css">
	
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>	
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../js/JQuery-formui.js"></script>
	<script type="text/javascript" src="../js/common.js"></script>
	
	<%@taglib prefix="s" uri="/struts-tags" %>
	
	<script type="text/javascript">
		function loaddata1(){
			$('#ff').form('load','form_data.json');
		}
		function loaddata2(){
			$('#ff').form('load',{
				name:'name2',
				email:'mymail@gmail.com',
				subject:'subject2',
				message:'message2',
				language:5
			});
		}
		function cleardata(){
			$('#baseinformation').form('clear');
		}
	</script>
</head>
<body>
	<h2>基本信息</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>从这里录入你的基本信息</div>
	</div>
	
	 <div style="margin:10px 0;">
		<!-- <a href="#" class="easyui-linkbutton" onclick="loaddata1()">Load1</a> 
		<a href="#" class="easyui-linkbutton" onclick="loaddata2()">Load2</a>  -->
		
	</div> 
	<div style="background:#fafafa;padding:10px;width:400px;height:600px;">
	    <form id="baseinformation" method="post" action="baseinformation">
	        <div>
	            <label for="name">姓名:</label>
	            <input class="easyui-validatebox" type="text" name="name" data-options="required:true"></input>
	        </div>
	        <div>
	            <label for="sex">性别:</label>
	            <input class="easyui-validatebox" type="text" name="sex" ></input>
	        </div>
	        <div>
	            <label for="birth">出生:</label>
	            <input class="easyui-validatebox" type="text" name="birth"></input>
	        </div>
	        <div>
	            <label for="mobile">手机:</label>
	            <input class="easyui-validatebox" type="text" name="mobile"></input>
	        </div>
	         <div>
	            <label for="communication">QQ:</label>
	            <input class="easyui-validatebox" type="text" name="communication"></input>
	        </div>
	        <div>
	            <label for="message">宣言:</label>
	            <textarea name="message" style="height:60px;"></textarea>
	        </div>
	        <div>
	            <label for="hobby">爱好:</label>
	            <textarea name="hobby" style="height:60px;"></textarea>
	        </div>
	        <div>
	            <label for="remark">备注:</label>
	            <textarea name="remark" style="height:60px;"></textarea>
	        </div>
	        <div>
	            <label for="nationality">国籍:</label>
				<input class="easyui-combobox" name="nationality"
						data-options="
								url:'combobox_data.json',
								valueField:'id',
								textField:'text',
								panelHeight:'auto'
						">
	        </div>
	        <div>
	            <input type="submit" value="提交">
	            <input type="submit" value="重置" onclick="cleardata()">
	        </div>
	    </form>
	</div>
	<h1><s:property value="#session.test1"/></h1>  
   ${applicationScope.app}<br>

   ${sessionScope.sess}<br>

   ${requestScope.req}<br>

   ${applicationScope.app2}<br>

   ${sessionScope.sess2}<br>

   ${requestScope.req2}<br>

	  
</body>
</html>
	
	<script type="text/javascript">
	var testend = "${applicationScope.app}"
	alert("testend==="+testend);
	</script>

