<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../assets/css/layui.css">
    <link rel="stylesheet" href="../assets/css/view.css"/>
    <link rel="icon" href="/favicon.ico">
    <title>管理后台</title>
</head>
<style type="text/css">
        table.altrowstable {
            font-family: verdana,arial,sans-serif;
            font-size:22px;
            color:#333333;
            border-width: 600px;
            border-color: #a9c6c9;
            border-collapse: collapse;
        }
        table.altrowstable th {
            border-width: 11px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }
        table.altrowstable td {
            border-width: 11px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }
        .oddrowcolor{
            background-color:#d4e3e5;
        }
        .evenrowcolor{
            background-color:#c3dde0;
        }
    </style>
    <script type="text/javascript">
        function altRows(id){
            if(document.getElementsByTagName){ 
                 
                var table = document.getElementById(id); 
                var rows = table.getElementsByTagName("tr");
                  
                for(i = 0; i < rows.length; i++){         
                    if(i % 2 == 0){
                        rows[i].className = "evenrowcolor";
                    }else{
                        rows[i].className = "oddrowcolor";
                    }     
                }
            }
        }
         
        window.onload=function(){
            altRows('alternatecolor');
        }
</script>

<body class="layui-view-body">

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/new_schema?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="root"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * FROM user_inf;
</sql:query>

    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a href="../Main.jsp">首页</a>
                  <a href="">用户</a>
                  <a><cite>用户组</cite></a>
                </span>
                <h2 class="title">用户组</h2>
            </div>
        </div>
        <div class="layui-row">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="form-box">
                        <div class="layui-form layui-form-item">
                            <div class="layui-inline">
                                <div class="layui-form-mid">用户名:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                  <input type="text" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid">邮箱:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                  <input type="text" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid">性别:</div>
                                <div class="layui-input-inline" style="width: 100px;">
                                    <select name="sex">
                                        <option value="1">男</option>
                                        <option value="2">女</option>
                                    </select>     
                                </div>
                                <button class="layui-btn layui-btn-blue">查询</button>
                                <button class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
               

                    </div>
                </div>
            </div>
        </div>
    </div>
                           <table  class="altrowstable" id="alternatecolor" >
<tr>
   <th>ID</th>
   <th>站点名</th>
   <th>站点地址</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.idshops}"/></td>
   <td><c:out value="${row.Name}"/></td>
   <td><c:out value="${row.Address}"/></td>
</tr>
</c:forEach>
</table>
    <script src="../assets/layui.all.js"></script>
  
</body>
</html>