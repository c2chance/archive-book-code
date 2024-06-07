<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>学生管理系统</title>    
</head>
 <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
 <!-- <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> -->
 <script type="text/javascript">
    $(function () {
        $("#search").click(function () {
            $.ajax({
                       type: "post",
                       url: "findInfoById",
                       data: $("#id"),
                       dataType: "json",
                       success: function (data) {
                    	   if(data != null){
                               var res = "";
                               res +=
                                   "<td>" + data.id + "</td> <td>" + data.name
                                   + "</td><td>" + data.sex + "</td><td>" + data.address + "</td>";
                               $("#student").html(res);   
                    	   }else{
                    		   alert("请输入正确的信息");
                    	   }                    	   
                       }
                   })
        })
    })
</script>
<body>
<center>
    <div style="margin-top: 25px">
        学号：<input type="text" id="id" name="id"/><input id="search" style="margin-left: 10px" type="button" value="查询"><br/>
    </div>
    <div style="margin-top: 50px">
        <table border="1">
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>地址</td>
            </tr>
            <tr id="student">
            </tr>
        </table>
    </div>
</center>
</body>
</html>