package sever;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Shop_inf
 */
@WebServlet("/Shop_inf")
public class Shop_inf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shop_inf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String tel =  null;
		String type =  null;
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
			ps=con.prepareStatement("select Tel,type from shops a join shop_address b where a.Address=b.Address and a.Name = \"" + user+"\"");
			rs=ps.executeQuery();
			while(rs.next()){
			tel = rs.getString(1);
			type = rs.getString(2);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
    list.add(tel);
	
	
	list.add(type);
	
	
	
        JSONArray json=JSONArray.fromObject(list);
        //设置编码
        response.setCharacterEncoding("utf-8");
        //写入到前台
        response.getWriter().write(/*result*/json.toString());
	}

}
