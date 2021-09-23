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
                  <a href="">Shop Management</a>
                  <a><cite>Edit</cite></a>
                </span>
                <h2 class="title">Setting</h2>
            </div>
        </div>
        <div class="layui-row">
   
            <div class="layui-card">
                <div class="layui-card-body">
                	<form action="showEditedShop.jsp" method="post">
                		<div class="form-box">
                        	<div class="layui-form layui-form-item">
                            	<div class="layui-inline">
                              	  	<div class="layui-form-mid">Please enter the  ID of edit shop:</div>
                               	 	<div class="layui-input-inline" style="width: 100px;">
                               	   <input type="text" autocomplete="off" class="layui-input" name="CNo">
                               	   
                               	 	</div>
                             <input type="submit" value="Delete"  class="layui-btn layui-btn-blue">
                                
                            	</div>
                       	 	</div>
                    	</div>
                    
  <h4>Please Enter the Valid Data</h4>
	

                </div>
            </div>
        </div>
    </div>
         <table  border="1"   style="opacity:0.6;position:absolute;left:20px; top: 250px; width:410px;height:300px;background-color:#8AC007 ; font-family:'../Montserrat-Bold.ttf';font-size:17px">
		
		
		<tr>
			<td>Name:</td>
			<td><input type="text" name="CN"/></td>
		</tr>
		
		<tr>
			<td>Tel:</td>
			<td><input type="text" name="TN"/></td>
		</tr>
		
		<tr>
			<td>Address_number:</td>
			<td><input type="text" name="KKXQ"/></td>
			
		</tr>
		<td>Address_floor:</td>
			<td> <input type="radio" name="FL" value="1" /> 1F
			 <input type="radio" name="FL" value="2" /> 2F
			  <input type="radio" name="FL" value="3" />3F
			  
			 </td>
		<tr>
		
		</tr>
		<tr>
			<td>Type:</td>
  
			<td> <input type="radio" name="CT" value="Goods" /> Goods
			 <input type="radio" name="CT" value="Toys" /> Toys
			  <input type="radio" name="CT" value="Cloth" />Cloth
			   <input type="radio" name="CT" value="Drink" />Drink
			 </td>
		</tr>
		
	
		<tr>
			<td>Capacity:</td>
			<td><input type="text" name="PR"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Edit"  class="layui-btn layui-btn-blue"></td>
			<td><input type="reset" value="Reset" class="layui-btn layui-btn-blue" ></td>
		</tr>
		</table>  
	</form>
	           
    <script src="../assets/layui.all.js"></script>
</body>
</html>