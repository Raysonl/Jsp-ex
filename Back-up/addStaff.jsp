<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="../assets/css/layui.css">
    <link rel="stylesheet" href="../assets/css/view.css"/>
    <title></title>
</head>
<body class="layui-view-body">
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a href="">Main</a>
                  <a href="">Personnel</a>
                  <a><cite>Add</cite></a>
                </span>
                <h2 class="title">Setting</h2>
            </div>
        </div>
        <div class="layui-row">
   
            <div class="layui-card">
                <div class="layui-card-body">
  <h4>课程号是主键，不能重复，每个信息都必须输入！</h4>
	<form action="showPrepareStaff.jsp" method="post">
	<table  border="1"  style="opacity:0.6;position:absolute;left:10px; top: 50px; width:400px;height:300px;background-color:#8AC007 ; font-family:'../Montserrat-Bold.ttf';font-size:24px">
		<tr>
			<td> ID:</td>
			<td><input type="text" name="CNo"/></td>
		</tr>
		
		<tr>
			<td>Name:</td>
			<td><input type="text" name="CN"/></td>
		</tr>
		
		<tr>
			<td>Work_year:</td>
			<td><input type="text" name="TN"/></td>
		</tr>
		
		
		<tr>
			<td>Sex:</td>
  
			<td> <input type="radio" name="SE" value="M" />Male
			 <input type="radio" name="SE" value="F" /> Female
			 </td>
		</tr>
		
		
		<tr>
			<td>Salary:</td>
			<td><input type="text" name="PR"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Add" class="layui-btn layui-btn-blue"></td>
			<td><input type="reset" value="Reset" class="layui-btn layui-btn-blue"></td>
		</tr>
	</table>
	</form>  
                </div>
            </div>
        </div>
    </div>
                     
    <script src="../assets/layui.all.js"></script>
</body>
</html>