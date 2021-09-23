package Connection;


import java.sql.*;
public class UserPrepare {
	int CNo;
    String CN;
    String  TN;
    String SE;
    int year;
    int mon;
    int day;
    int count;
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
		return day;
	}
	public void setSC(int SC) {
		this.day = SC;
	}
	public String getPR() {
		return address;
	}
	public void setPR(String PR) {
		this.address = PR;
	}
	

  //修改数据
    public void editUser(){
    	Connection con = null;
    	PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			ps=con.prepareStatement("update user_inf set  `Name`=?, `Sex`=?, `Birthday`=?"+"/?"+"/?"+", `Address`=? where iduser = "+CNo);
			
			ps.setString(1, CN);	
			ps.setString(2, SE);
			ps.setInt(3, day);
			ps.setInt(4, mon);
			ps.setInt(5, year);
			ps.setString(6, address);
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
			ps=con.prepareStatement("select * from user_inf");
			rs=ps.executeQuery();
			queryResult.append("<table class=altrowstable id=alternatecolor>");
				queryResult.append("<tr>");
				queryResult.append("<th>ID</th>");
				queryResult.append("<th>Name</th>");
				queryResult.append("<th>Password</th>");
				queryResult.append("<th>Sex</th>");
				queryResult.append("<th>Birthday Year</th>");
				queryResult.append("<th>Birthday Month</th>");
				queryResult.append("<th>Birthday Day</th>");
				queryResult.append("<th>Address</th>");
			queryResult.append("</tr>");
		while(rs.next()){
			if(rs.getString(2)!=null) {
			queryResult.append("<tr>");
				queryResult.append("<td>"+rs.getString(1)+"</td>");
				queryResult.append("<td>"+rs.getString(2)+"</td>");
				queryResult.append("<td>"+rs.getString(3)+"</td>");
				queryResult.append("<td>"+rs.getString(4)+"</td>");
				queryResult.append("<td>"+rs.getString(5)+"</td>");
				queryResult.append("<td>"+rs.getString(6)+"</td>");
				queryResult.append("<td>"+rs.getString(7)+"</td>");
				queryResult.append("<td>"+rs.getString(8)+"</td>");
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
		    String selectSql="select * from user_inf where 1=1 ";
			if(address!=null&&address.length()>0){
				selectSql=selectSql+" and Address='"+address+"' ";
			}
			if(year>0){
				selectSql=selectSql+" and Year <"+(2021-year)+" ";
			}
			if(SE!=null&&SE.length()>0){
				selectSql=selectSql+" and Sex='"+SE+"' ";
			}
			ps=con.prepareStatement(selectSql);
			rs=ps.executeQuery();
			queryPrepareResultBy.append("<table class=altrowstable id=alternatecolor>");
				queryPrepareResultBy.append("<tr>");
				queryPrepareResultBy.append("<th>ID</th>");
				queryPrepareResultBy.append("<th>Name</th>");
				queryPrepareResultBy.append("<th>Password</th>");
				queryPrepareResultBy.append("<th>Sex</th>");
				queryPrepareResultBy.append("<th>Birthday Year</th>");
				queryPrepareResultBy.append("<th>Birthday Month</th>");
				queryPrepareResultBy.append("<th>Birthday Day</th>");
				queryPrepareResultBy.append("<th>Address</th>");
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
				queryPrepareResultBy.append("<td>"+rs.getString(8)+"</td>");
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