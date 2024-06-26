<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
    <title>发货数量统计</title>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/demo.css">
	
	<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>	
	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="../js/JQuery-formui.js"></script>
	<script type="text/javascript" src="../js/common.js"></script>
	
	<style type='text/css'>
		body{margin:0px;padding:0px;}
	</style>
  </head>  
  <body>
    <!-- 查询条件 -->
	<div id="formdata" class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div style="margin-left:30px;">		
			  选择日期：
			<input id="dateStart" onclick="WdatePicker();" type='text'/>-<input id="dateEnd" onclick="WdatePicker();" type='text'/>
			<a href="#" id="btnQuery" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
			<!-- <a href="#" id="btnQuery2" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询hibernate</a> -->
			<a href='#' id="btnSaveFile" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" >导出CSV</a>
		</div>
	</div>
	
	<!-- 显示结果 -->
	<table id="datagrid"></table>
	<script type="text/javascript">
	
$(function(){
		//查询按钮
		$("#btnQuery").click(function(){			
			binddatagrid();
		});
		
		//随窗体缩放
		$(window).resize(function(){
			$('#datagrid').datagrid('resize');
		});
		
		//绑定数据列表
		function binddatagrid(condition) {
			//获取查询条件
			var condition =$("#formdata").toJsonString();
			condition = escape(encodeURIComponent(condition));
			
			//ajax查询数据			
			var url="SendAmount.action";
			if(condition && condition.length>0)
				url += "?condition="+condition;
			$('#datagrid').datagrid({
				nowrap : true,
				fitColumns : true,
				pageList : [ 20, 50,100 ],
				singleSelect : false,
				collapsible : false,
				url : url,				
				frozenColumns : [ [ {
					field : 'ck',
					checkbox : false
				} ] ],
				columns : [ [ 
				{
					field : 'CITY',
					title : '城市',
					width : 100,
					sortable : true					
				},
				{
					field : 'GOODS',
					title : '产品',
					width : 100,
					sortable : true					
				}, 
				{
					field : 'AMOUNT',
					title : '数量',
					width : 100,
					rowspan : 2
				}, 
				{
					field : 'RECEIVER',
					title : '接收人',
					width : 100,
					sortable : true,
					rowspan : 2
				}, 
				{
					field : 'SENDDATE',
					title : '发送时间',
					width :150,
					sortable : true,
					rowspan : 2
				},
			    {
					field : 'TAKEDATE',
					title : '接收时间',
					width : 150,
					sortable : true,
					rowspan : 2
		    	},
				{
					field : 'REMARK',
					title : '备注',
					width :100,
					sortable : true,
					rowspan : 2
				}
				 ] ],
				pagination : false,
				rownumbers : false
			});

			$('#datagrid').datagrid('getPager').pagination( {
				beforePageText : '第',
				afterPageText : '页    共 {pages} 页',
				displayMsg : '当前显示从{from}到{to}共{total}记录',
				onBeforeRefresh : function(pageNumber, pageSize) {
					$('#datagrid').datagrid('clearSelections');
			}
			});
		};
	});
			$("#btnSaveFile").click(function(){
			$.messager.progress({
				title:'请等待',
				msg:'数据处理中...'
			});
				
				var condition = $("#formdata").toJsonString();
				var exportflag = "yes";
		     	condition = escape(encodeURIComponent(condition));	
				var url='SendAmount.action?condition='+condition+'&exportflag='+exportflag;
				
		     	$.ajax( {
		     		type : "post",
					url : url,
					error : function(event,request, settings) {
						$.messager.alert("提示消息", "请求失败", "info");
					},
					success : function(data) {
					$.messager.progress('close');
							var name = data.rows;
							window.location.href = "FileDownload.action?number=1&fileName="+name;
					}
				});	
			});			
	</script>
  </body>
</html>
