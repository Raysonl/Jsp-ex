package Connection;


import java.sql.*;
public class NFCPrepare {
	int CNo;
    String CN;
    String  TN;
    String SE;
    int year;
    int mon;
    int day_cap;
    int cap;
    String address;
    StringBuffer queryResult;//查询所有数据
    StringBuffer queryResultBy;//根据条件查询所有数据

    
    public int getCNo() {
		return CNo;
	}
	public void setCNo(int CNo) {
		this.CNo = CNo;
	}
	public String getCN() {
		return CN;
	}
	public void setCN(String CN) {
		this.CN = CN;
	}
	public String getSex() {
		return SE;
	}
	public void setSE(String SE) {
		this.SE = SE;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int Year) {
		this.year = Year;
	}
	public int getCT() {
		return mon;
	}
	public void setCT(int CT) {
		this.mon = CT;
	}
	
	public int getSC() {
		return day_cap;
	}
	public void setSC(int SC) {
		this.day_cap = SC;
	}
	public String getPR() {
		return address;
	}
	public void setPR(String PR) {
		this.address = PR;
	}


	
  //修改数据
    public void editCap(){
    	Connection con = null;
    	PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			ps=con.prepareStatement("update  shop_address as b, shops as a set Allowable_least_Cap=?  where a.Address=b.Address and a.idshops = "+CNo);
			
			ps.setInt(1, day_cap);	
		System.out.println(ps);
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
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
    }
    //获得所有信息
    public StringBuffer getQueryResult(){
		queryResult=new StringBuffer();
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
			ps=con.prepareStatement("select * from nfc_inf");
			rs=ps.executeQuery();
			queryResult.append("<table class=altrowstable id=alternatecolor>");
				queryResult.append("<tr>");
				queryResult.append("<th>ID</th>");
				queryResult.append("<th>Time</th>");
				queryResult.append("<th>Position</th>");
				queryResult.append("<th>User_id</th>");
			queryResult.append("</tr>");
		while(rs.next()){
			if(rs.getString(2)!=null) {
			queryResult.append("<tr>");
				queryResult.append("<td>"+rs.getString(1)+"</td>");
				queryResult.append("<td>"+rs.getString(2)+"</td>");
				queryResult.append("<td>"+rs.getString(3)+"</td>");
				queryResult.append("<td>"+rs.getString(4)+"</td>");
				queryResult.append("</tr>");
				}
			}
			queryResult.append("</table>");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
		return queryResult;
	}

	//根据条件查询
	public StringBuffer getQueryPrepareResultBy(){
		StringBuffer queryPrepareResultBy = new StringBuffer();
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
			ps=con.prepareStatement("SELECT idshops, Name, Tel, a.Address,Type,Capacity,Allowable_least_Cap FROM shops  a join shop_address  b where a.Address = b.Address");
			rs=ps.executeQuery();
			queryPrepareResultBy.append("<table class=altrowstable id=alternatecolor>");
			queryPrepareResultBy.append("<tr>");
			queryPrepareResultBy.append("<th>ID</th>");
			queryPrepareResultBy.append("<th>Name</th>");
			queryPrepareResultBy.append("<th>TEL</th>");
			queryPrepareResultBy.append("<th>Address</th>");
			queryPrepareResultBy.append("<th>Type</th>");
			queryPrepareResultBy.append("<th>Current_Capacity</th>");
			queryPrepareResultBy.append("<th>Allowable_least_Capacity</th>");
			queryPrepareResultBy.append("</tr>");
			
		while(rs.next()){
			queryPrepareResultBy.append("<tr>");
			queryPrepareResultBy.append("<td>"+rs.getString(1)+"</td>");
			queryPrepareResultBy.append("<td>"+rs.getString(2)+"</td>");
			queryPrepareResultBy.append("<td>"+rs.getString(3)+"</td>");
			queryPrepareResultBy.append("<td>"+rs.getString(4)+"</td>");
			queryPrepareResultBy.append("<td>"+rs.getString(5)+"</td>");
			queryPrepareResultBy.append("<td>"+rs.getString(6)+"</td>");
			queryPrepareResultBy.append("<td>"+rs.getString(7)+"</td>");
			queryPrepareResultBy.append("</tr>");
		}
		queryPrepareResultBy.append("</table>");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
		return queryPrepareResultBy;
	}
}