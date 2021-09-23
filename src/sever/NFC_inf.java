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
 * Servlet implementation class NFC_inf
 */
@WebServlet("/NFC_inf")
public class NFC_inf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NFC_inf() {
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
		String result = null;
		String user=request.getParameter("id");
		String time=request.getParameter("time");
		String des=request.getParameter("des");
		System.out.println("用户名："+user);
		System.out.println("用户名1："+time);
		System.out.println("用户名2："+des);
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
	 	ps=con.prepareStatement("insert into  nfc_inf (`id`, `time`, `des`,`user_id`)  values(?,?,?,?)");
		ps.setString(1, user);//Using JDBC
		ps.setString(2, time);	
		ps.setString(3, des);
		ps.setInt(4, 1);
			ps.executeUpdate();
		 result = "Successful";
		}catch (SQLException e) {
			e.printStackTrace();
			result = "Fail";
		}
	
	
		
		finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				
				}
				if(con!=null){
					con.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	
	list.add("Ans:");
	
	
	list.add(result);
	
	
	
      JSONArray json=JSONArray.fromObject(list);
        //Coding
        response.setCharacterEncoding("utf-8");
        //Writing message to front-end
     response.getWriter().write(/*result*/json.toString());
 
		
	}

}
