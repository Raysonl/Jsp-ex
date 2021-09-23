<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>

<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<%@ page import="Connection.NFCPrepare" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="../assets/css/layui.css">
    <link rel="stylesheet" href="../assets/css/view.css"/>
    <title></title>
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
 <sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/new_schema?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="root"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT COUNT(iduser) as c FROM user_inf;
</sql:query>

<sql:query dataSource="${snapshot}" var="result1">
SELECT COUNT(time) as c FROM nfc_inf;
</sql:query>
<body class="layui-view-body">
    <div class="layui-content">
                       
        <div class="layui-row layui-col-space20">
            <div class="layui-col-sm6 layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-body chart-card">
                        <div class="chart-header">
                            <div class="metawrap">
                                <div class="meta">
                                    <span>Total User</span>
                                </div>
                                <div class="total">
                                	<c:forEach var="row" items="${result.rows}">

										<c:out value="${row.c}"/>
   

									</c:forEach>
								</div>
                            </div>
                        </div>
                        <div class="chart-body">
                            <div class="contentwrap">
                               Persons in center
                            </div>
                        </div>
                        <div class="chart-footer">
                            <div class="field">
                                <span>Register_NFC_Record</span>
                                <span><c:forEach var="row" items="${result1.rows}">

										<c:out value="${row.c}"/>
   

									</c:forEach></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm6 layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-body chart-card">
                        <div class="chart-header">
                            <div class="metawrap">
                                <div class="meta">
                                    <span>Total User</span>
                                </div>
                                  <div class="total">
                                	<c:forEach var="row" items="${result.rows}">

										<c:out value="${row.c}"/>
   

									</c:forEach>
								</div>
                            </div>
                        </div>
                        <div class="chart-body">
                            <div class="contentwrap">
                                  Persons in center
                            </div>
                        </div>
                        <div class="chart-footer">
                            <div class="field">
                                <span>Register_NFC_Record</span>
                                <span><c:forEach var="row" items="${result1.rows}">

										<c:out value="${row.c}"/>
   

									</c:forEach></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm6 layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-body chart-card">
                        <div class="chart-header">
                            <div class="metawrap">
                                <div class="meta">
                                    <span>Total User</span>
                                </div>
                                  <div class="total">
                                	<c:forEach var="row" items="${result.rows}">

										<c:out value="${row.c}"/>
   

									</c:forEach>
								</div>
                            </div>
                        </div>
                        <div class="chart-body">
                            <div class="contentwrap">
                                Persons in center
                            </div>
                        </div>
                        <div class="chart-footer">
                            <div class="field">
                                <span>Register_NFC_Record</span>
                                <span><c:forEach var="row" items="${result1.rows}">

										<c:out value="${row.c}"/>
   

									</c:forEach></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm6 layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-body chart-card">
                        <div class="chart-header">
                            <div class="metawrap">
                                <div class="meta">
                                    <span>Total User</span>
                                </div>
                                  <div class="total">
                                	<c:forEach var="row" items="${result.rows}">

										<c:out value="${row.c}"/>
   

									</c:forEach>
								</div>
                            </div>
                        </div>
                        <div class="chart-body">
                            <div class="contentwrap">
                                Persons in center
                            </div>
                        </div>
                        <div class="chart-footer">
                            <div class="field">
                               <span>Register_NFC_Record</span>
                                <span><c:forEach var="row" items="${result1.rows}">

										<c:out value="${row.c}"/>
   

									</c:forEach></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-card">
                    <div class="layui-tab layui-tab-brief">
                        <ul class="layui-tab-title">
                            <li class="layui-this">Edit Allowable capacity</li>
                            <li>Active NFC Record</li>
                        </ul>
                        <div class="layui-tab-content">
                            <div class="layui-tab-item layui-show">
                             	<form action="showPrepareNFC.jsp" method="post">  
                             	<div class="layui-inline">
                               
                              	  	<div class="layui-form-mid">Please enter the  ID of edit shop:</div>
                               	 	<div class="layui-input-inline" style="width: 100px;">
                               	   <input type="text" autocomplete="off" class="layui-input" name="CNo">
                               	   <br>
                             
                               	 	</div>
                                   <h4>Please Enter the Valid Capacity</h4> 
                                    	   <br>
                                  <input type="text" autocomplete="off" class="layui-input" name="SC">
                               <input type="submit" value="Edit"  class="layui-btn layui-btn-blue">
                            	</div>  
                            	</form>
                            	
                            </div>
                            <div class="layui-tab-item">
                    
                   			 <%request.setCharacterEncoding("GBK");%>
							<jsp:useBean id="goods" class="Connection.NFCPrepare" scope="page"></jsp:useBean>
							<jsp:setProperty property="*" name="goods"/>
	
							<jsp:getProperty property="queryResult" name="goods"/><!-- 获得查询结果 -->
 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="../assets/layui.all.js"></script>
    <script>
     var element = layui.element;
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
 
</body>
</html>