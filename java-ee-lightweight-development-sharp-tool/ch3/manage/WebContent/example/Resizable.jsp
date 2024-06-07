<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Resizable调整大小</title>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/demo.css">
	
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script styp="text/javascript" src="../easyui/easyloader.js" ></script>
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../js/JQuery-formui.js"></script>
	<script type="text/javascript" src="../js/common.js"></script>
  </head>  
  <body>
	<div id="aa" class="easyui-resizable" data-options="maxWidth:800,maxHeight:600" style="width:100px;height:100px;border:1px solid #ccc;"></div>
	<div id="bb" style="width:100px;height:100px;border:1px solid #ccc;"></div>
	<script type="text/javascript">
	        
	$('#bb').resizable({ 
	maxWidth:800, 
	maxHeight:600 
	});

	</script>
  </body>
</html>
