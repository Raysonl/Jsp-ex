package sever;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class RE
 */
@WebServlet("/RE")
public class RE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int capacity =  0;
		int least_capacity =  0;
		String add =null;
		String result = null;
		String user=request.getParameter("name");
	
		System.out.println("用户名："+user);
		
		  //将List转化为JSON
		System.out.println("----------");
		ArrayList<String> list=new ArrayList<String>();
	
		
		
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try {
	 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			ps=con.prepareStatement("select Capacity from shops a join shop_address b where a.Address=b.Address and a.Name = '" + user+"'");
			rs=ps.executeQuery();
			while(rs.next()){
			capacity = rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	try {
	 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			ps2=con.prepareStatement("select Allowable_least_Cap from  shops a join shop_address b where  a.Address=b.Address and a.Name = '" + user+"'");
			rs1=ps2.executeQuery();
			while(rs1.next()){
			least_capacity = rs1.getInt(1);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	if (capacity < least_capacity) {
		result = "N";
	}
	else {
		result = "Y";
		capacity -=1;
		try {
			ps3 = con.prepareStatement("select Address from shops where Name = '"+user+"'");
			rs2 = ps3.executeQuery();
			while(rs2.next()) {
				add = rs2.getString(1);
			}
			ps1 = con.prepareStatement("update shop_address set Capacity= ?  where Address = '" + add+"'");
			ps1.setDouble(1,capacity);
			ps1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			try{
				if(rs!=null){
					rs.close();
					rs1.close();
					rs2.close();
				}
				if(ps!=null){
					ps.close();
					ps1.close();
					ps2.close();
					ps3.close();
				}
				if(con!=null){
					con.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	list.add("Ans:");
	
	
	list.add(result);
	
	
	
        JSONArray json=JSONArray.fromObject(list);
        //设置编码
        response.setCharacterEncoding("utf-8");
        //写入到前台
        response.getWriter().write(/*result*/json.toString());
 
		
	}

}
