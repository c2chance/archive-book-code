<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>发货城市统计</title>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../css/demo.css">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/bootstrap.min.css">

<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/JQuery-formui.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="../echarts/echarts.min.js"></script>

<style type='text/css'>
body {
	margin: 0px;
	padding: 0px;
}
</style>
</head>
<body>
	<!-- 查询条件 -->
	<div id="formdata" class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div style="margin-left:30px;">
			选择日期： <input id="dateStart" onclick="WdatePicker();" type='text' />-<input
				id="dateEnd" onclick="WdatePicker();" type='text' /> <a href="#"
				id="btnQuery" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'">查询</a> <a href='#'
				id="btnSaveFile" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit'">导出CSV</a> <a href='#'
				id="btnSaveExcel" class="easyui-linkbutton"
				data-options="iconCls:'icon-edit'">导出Excel</a>
			<button type="button" class="btn btn-default">默认样式</button>
			<button type="button" class="btn btn-success">成功样式</button>
			<button type="button" class="btn btn-info">信息样式</button>
		</div>

		<table class="table">
			<caption>经典的表格布局</caption>
			<thead>
				<tr>
					<th>城市</th>
					<th>产品</th>
					<th>数量</th>
				</tr>
			</thead>
			<tbody>
				<tr class="active">
					<td>杭州</td>
					<td>苹果</td>
					<td>100</td>
				</tr>
				<tr class="success">
					<td>西安</td>
					<td>桔子</td>
					<td>200</td>
				</tr>
				<tr class="warning">
					<td>张掖</td>
					<td>麻辣粉</td>
					<td>300</td>
				</tr>
			</tbody>
		</table>


	</div>



	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div id="main1" style="width: 600px;height:400px;"></div>

	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main1'));

		// 指定图表的配置项和数据
		var option = {
			title : {
				text : 'ECharts 简单例子'
			},
			tooltip : {},
			legend : {
				data : [ '销量' ]
			},
			xAxis : {
				data : [ "杭州", "西安", "张掖" ]
			},
			yAxis : {},
			series : [ {
				name : '销量',
				type : 'bar',
				data : [ 50, 30, 20 ]
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	</script>




	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div id="main2" style="width: 600px;height:400px;"></div>

	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main2'));

		// 指定图表的配置项和数据
		var option = {
			legend : {
				data : [ '高度(km)与气温(°C)变化关系' ]
			},
			tooltip : {
				trigger : 'axis',
				formatter : "Temperature : <br/>{b}km : {c}°C"
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : {
				type : 'value',
				axisLabel : {
					formatter : '{value} °C'
				}
			},
			yAxis : {
				type : 'category',
				axisLine : {
					onZero : false
				},
				axisLabel : {
					formatter : '{value} km'
				},
				boundaryGap : false,
				data : [ '0', '10', '20', '30', '40', '50', '60', '70', '80' ]
			},
			series : [ {
				name : '高度(km)与气温(°C)变化关系',
				type : 'line',
				smooth : true,
				lineStyle : {
					normal : {
						width : 3,
						shadowColor : 'rgba(0,0,0,0.4)',
						shadowBlur : 10,
						shadowOffsetY : 10
					}
				},
				data : [ 15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7,
						-76.5 ]
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	</script>



	<!-- 显示结果 -->
	<table id="datagrid"></table>
	<script type="text/javascript">
		setInterval(function() {

			for ( var i = 0; i < 5; i++) {
				data.shift();
				data.push(randomData());
			}

			myChart.setOption({
				series : [ {
					data : data
				} ]
			});
		}, 1000);

		$(function() {
			//查询按钮
			$("#btnQuery").click(function() {
				binddatagrid();
			});

			//随窗体缩放
			$(window).resize(function() {
				$('#datagrid').datagrid('resize');
			});

			//绑定数据列表
			function binddatagrid(condition) {
				//获取查询条件
				var condition = $("#formdata").toJsonString();
				condition = escape(encodeURIComponent(condition));

				//ajax查询数据			
				var url = "SendCity.action";
				if (condition && condition.length > 0)
					url += "?condition=" + condition;
				$('#datagrid').datagrid({
					nowrap : true,
					fitColumns : true,
					pageList : [ 20, 50, 100 ],
					singleSelect : true,
					collapsible : false,
					url : url,
					frozenColumns : [ [ {
						field : 'ck',
						checkbox : true
					} ] ],
					columns : [ [ {
						field : 'CITY',
						title : '城市',
						width : 100,
						sortable : true
					}, {
						field : 'GOODS',
						title : '产品',
						width : 100,
						sortable : true
					}, {
						field : 'AMOUNT',
						title : '数量',
						width : 100,
						rowspan : 2
					}, {
						field : 'RECEIVER',
						title : '接收人',
						width : 100,
						sortable : true,
						rowspan : 2
					}, {
						field : 'TAKEDATE',
						title : '接收时间',
						width : 150,
						sortable : true,
						rowspan : 2
					}, {
						field : 'SENDDATE',
						title : '发送时间',
						width : 150,
						sortable : true,
						rowspan : 2
					}, {
						field : 'REMARK',
						title : '备注',
						width : 100,
						sortable : true,
						rowspan : 2
					} ] ],
					pagination : true,
					rownumbers : true
				});

				$('#datagrid').datagrid('getPager').pagination({
					beforePageText : '第',
					afterPageText : '页    共 {pages} 页',
					displayMsg : '当前显示从{from}到{to}共{total}记录',
					onBeforeRefresh : function(pageNumber, pageSize) {
						$('#datagrid').datagrid('clearSelections');
					}
				});
			}
			;
		});
		$("#btnSaveFile")
				.click(
						function() {
							$.messager.progress({
								title : '请等待',
								msg : '数据处理中...'
							});

							var condition = $("#formdata").toJsonString();
							var exportflag = "csv";
							condition = escape(encodeURIComponent(condition));
							var url = 'SendCity.action?condition=' + condition
									+ '&exportflag=' + exportflag;

							$
									.ajax({
										type : "post",
										url : url,
										error : function(event, request,
												settings) {
											$.messager.alert("提示消息", "请求失败",
													"info");
										},
										success : function(data) {
											$.messager.progress('close');
											var name = data.rows;
											window.location.href = "FileDownload.action?number=1&fileName="
													+ name;
										}
									});
						});

		$("#btnSaveExcel")
				.click(
						function() {
							$.messager.progress({
								title : '请等待',
								msg : '数据处理中...'
							});
							var condition = $("#formdata").toJsonString();
							var exportflag = "excel";
							condition = escape(encodeURIComponent(condition));
							var url = 'SendCity.action?condition=' + condition
									+ '&exportflag=' + exportflag;

							$
									.ajax({
										type : "post",
										url : url,
										error : function(event, request,
												settings) {
											$.messager.alert("提示消息", "请求失败",
													"info");
										},
										success : function(data) {
											$.messager.progress('close');
											var name = data.rows;
											alert(name);
											window.location.href = "FileDownload.action?number=2&fileName="
													+ name;
										}
									});
						});
	</script>
</body>
</html>
