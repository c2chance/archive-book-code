<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Parser解析器</title>
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
	<div id="dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true">   
    Dialog Content.    
</div>  
	<div id="ff">Dialog Content.</div>  
	
	<script type="text/javascript">        
$('#ff').dialog({    
    title: 'My Dialog',    
    width: 400,    
    height: 200,    
    closed: false,    
    cache: false,    
    modal: true   
});    
 		
	</script>
  </body>
</html>
