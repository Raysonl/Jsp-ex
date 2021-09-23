
<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
<head>
<title>使用预处理语句</title>
</head>
<body bgcolor="LightYellow">
	<h4>课程号是主键，不能重复，每个信息都必须输入！</h4>
	<form action="showPrepareGoods.jsp" method="post">
	<table border="1">
		<tr>
			<td>课程号:</td>
			<td><input type="text" name="CNo"/></td>
		</tr>
		
		<tr>
			<td>课程名称:</td>
			<td><input type="text" name="CN"/></td>
		</tr> 
		
		<tr>
			<td>教师姓名:</td>
			<td><input type="text" name="TN"/></td>
		</tr>
		
		<tr>
			<td>开课学期:</td>
			<td><input type="text" name="KKXQ"/></td>
		</tr>
		
		<tr>
			<td>课程学时:</td>
			<td><input type="text" name="CT"/></td>
		</tr>
		
		<tr>
			<td>课程学分:</td>
			<td><input type="text" name="SC"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="添加"></td>
			<td><input type="reset" value="重置"></td>
		</tr>
	</table>
	</form>
</body>
</html>