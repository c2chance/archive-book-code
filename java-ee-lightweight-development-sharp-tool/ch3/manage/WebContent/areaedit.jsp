<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>�������</title>
	
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<link rel="stylesheet" type="text/css" href="css/fw.css" ></link>
	
	<script type="text/javascript" src="easyui/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/JQuery-formui.js"></script>
	<script type="text/javascript" src="areaedit.js"></script>
	
</head>
<body>

	<div data-options="fit:true"  >
		<!-- ������ -->
		<div class="editcontent" 
			style="padding:10px;background:#fff;border:1px solid #ccc;height:200px;">

			<div id="maindata" >
			
				<!-- ����Ҫ��ʾ���ֶ� -->
				<div style="display:none;">
					<input id="LEVEL" type="text" >
					<input id="ICODE" type="text" >
				</div>
				
				<table class="table table-hover table-condensed">
					<tr>
						<th>����</th>
						<td><input id="NO" type="text" class="easyui-validatebox span2" data-options="required:true">
						</td>
						<th>�ϼ�</th>
						<td>
						<input id="PARENTICODE" type="text" class="easyui-combotree span2" data-options="url:'AREAFindTree.action'">
						</td>
					</tr>
					<tr>
						<th>����</th>
						<td><input id="NAME" type="text" class="easyui-validatebox span2" data-options="required:true">
						</td>
						<th>ƴ����</th>
						<td><input id="SPELLNO" type="text" class="span2" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th>�Զ�����</th>
						<td><input id="CUSTOMNO" type="text" class="span2" >
						</td>
						<th>�ʱ�</th>
						<td><input id="ZIP" type="text" class="span2" >
						</td>
					</tr>
					<tr>
						<th>��ϵ�绰</th>
						<td colspan="3"><input id="TEL" type="text" class="span2" >
						</td>
					</tr>
					<tr>
						<th>��ַ</th>
						<td colspan="3"><input id="ADDRESS" type="text" class="span5" style="width:322px;" >
						</td>
					</tr>
				</table>
				
			</div>

		</div>

		<!-- ���水ť�� -->
		<div style="text-align:center;padding:5px 0;">
			<a id="btnSave" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"  >�� ��</a> 
			&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="btnCancel" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"  >ȡ ��</a>
		</div>
	</div>

	

</body>
</html>