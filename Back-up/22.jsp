<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mysql.jdbc.Driver" %>   
<%@ page import="java.sql.*"%>
<html>
<head><title>通过JSP读取数据库中的表</title></head>
<body>
 <%  
	try {  
	Class.forName("com.mysql.cj.jdbc.Driver");  //加载数据库驱动
	String url = "jdbc:MySQL://localhost:3306/new_schema?&useSSL=false&serverTimezone=UTC"; //指向数据库table1
	String username = "root";  //数据库用户名
	String password = "root";  //数据库用户密码
	Connection conn = DriverManager.getConnection(url, username, password);  //连接数据库
	if(conn != null){  
		out.print("数据库连接成功！");
		out.println("<br />"); 
		out.println("-------------------------------"); 
		out.print("<br />");            
		Statement stmt = null;  
		ResultSet rs = null;  
		String sql ="select * from new_schema.shops";  //查询语句
	
		stmt = conn.createStatement();  
		rs = stmt.executeQuery(sql);  
		out.println("执行结果如下所示:"); 
		out.println("<br />"); 
		out.println("-------------------------------"); 
		out.println("<br />"); 
		out.println("姓名" + "\t" + "姓别"+"\t"+"年龄"+"\t"+"工资");
		out.println("<br />"); 
	
		while (rs.next()) {  
		out.println(rs.getInt("idshops")+"   &nbsp  "+rs.getString("Name")+"  &nbsp "+rs.getString("Address")+"  &nbsp "+rs.getString("Type")); //将数据库表格查询结果输出  
		out.print("<br />");  

		      }  
		
		
		 out.println("<table border='1'  style='opacity:0.6;position:absolute;left:40px; top: 250px; width:1000px;height:300px;background-color:#8AC007'>") ;
		 out.println( "<tr>" ) ;
		 out.println( "<th>ID</th>" ) ;
		 out.println( "<th>站点名</th>" ) ;
		 out.println( "<th>站点地址</th>" ) ;
		 out.println("</tr>") ;

		 
		 out.println("<tr>" ) ;

	     out.println(  " <td> www</td>") ;
	     out.println( "</tr>" ) ;

	  out.println(  "</table>") ;

		 
		}
		else{  
			out.print("连接失败！");  
              }           
        }
		catch (Exception e) {        
            out.print("数据库连接异常！");  
             }  
%>      
</body>
</html>