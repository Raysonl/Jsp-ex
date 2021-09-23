<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ page import="Connection.ShopPrepare" %>
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
    <div class="layui-content">
        <div class="layui-page-header">
            <div class="pagewrap">
                <span class="layui-breadcrumb">
                  <a href="">Main</a>
                  <a href="">User</a>
                  <a><cite>Add</cite></a>
                </span>
                <h2 class="title"><a href="editShop.jsp">Back</a></h2>
            </div>
        </div>
         <div class="layui-row">
         
            <div class="layui-card">
                <div class="layui-card-body">
	<%
	request.setCharacterEncoding("GBK");
	%>
	<jsp:useBean id="prepareGoods" class="Connection.ShopPrepare" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="prepareGoods"/>
	<%
	int check = prepareGoods.editShops();
	if(check ==-1)
		prepareGoods.deleteShops();
	%>
	<jsp:getProperty property="queryResult" name="prepareGoods"/>
				</div>
			</div>
		</div>  
	 </div>
	
   
                     
    <script src="../assets/layui.all.js"></script>
</body>
</html>