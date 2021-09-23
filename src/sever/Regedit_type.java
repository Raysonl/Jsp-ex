package sever;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
public class Regedit_type extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ServletContext ser = getServletContext();
		//ApplicationContext ioc = (ApplicationContext) ser.getAttribute("app");
		doPost(request, response);
		//Regedit re=ioc.getBean(Regedit.class);
		//re.login();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name =  null;
		String floor =  null;
		String num =  null;
		String user=request.getParameter("name");
	
		System.out.println("用户名："+user);
		
		  //将List转化为JSON
		System.out.println("----------");
		ArrayList<String> list=new ArrayList<String>();
	
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try {
	 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			ps=con.prepareStatement("select Name, Floor, Number from shops a join shop_address b where a.Address=b.Address and b.Type = \"" + user+"\"");
			rs=ps.executeQuery();
			while(rs.next()){
			name = rs.getString(1);
			floor = rs.getString(2);
			num = rs.getString(3); 
			list.add(name);
	
	
			list.add(floor);
	
			list.add(num);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
   
	
        JSONArray json=JSONArray.fromObject(list);
        //设置编码
        response.setCharacterEncoding("utf-8");
        //写入到前台
        response.getWriter().write(/*result*/json.toString());
	}
	}
 
