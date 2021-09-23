package Connection;


import java.sql.*;
public class StaffPrepare {
	int CNo;
    String CN;
    int  TN;
    String SE;
    String CT;
    String SC;
    double PR;
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
	public int getTN() {
		return TN;
	}
	public void setTN(int TN) {
		this.TN = TN;
	}
	public String getKKXQ() {
		return SE;
	}
	public void setKKXQ(String KKXQ) {
		this.SE = KKXQ;
	}
	public String getCT() {
		return CT;
	}
	public void setCT(String CT) {
		this.CT = CT;
	}
	public String getSE() {
		return SE;
	}
	public void setSE(String SE) {
		this.SE = SE;
	}
	public double getPR() {
		return PR;
	}
	public void setPR(double PR) {
		this.PR = PR;
	}
	//添加数据
    public void addStaffs(){
    	Connection con = null;
    	PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			ps=con.prepareStatement("insert into personnel (`idpersonnel`, `Name`, `Sex`, `Work_year`,`Salary`)  values(?,?,?,?,?)");
			ps.setInt(1, CNo);
			ps.setString(2, CN);	
		
			ps.setString(3, SE);	
			ps.setInt(4, TN);
			ps.setDouble(5, PR);
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
  //修改数据
    public int editStaffs(){
    	Connection con = null;
    	PreparedStatement ps = null;	
    	if(CN!=null&&SE!=null&&TN!=0&&PR!=0) {
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
	
    		try {
    			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
    			ps=con.prepareStatement("update personnel set  `Name`=?, `Sex`=?, `Work_year`=?, `Salary`=?  where idpersonnel = "+CNo);
			
    			ps.setString(1, CN);	
			
    			ps.setString(2, SE);
    			ps.setInt(3, TN);
	
    			ps.setDouble(4, PR);
    			ps.executeUpdate();
    			return 0;
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
    	if(CN!=null||SE!=null||TN!=0||PR!=0){
    		return 0;
    		}
    	return -1;
    }
    
    //修改数据
    public void deleteStaffs(){
    	Connection con = null;
    	PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			ps=con.prepareStatement("delete from personnel  where idpersonnel = "+CNo);
			if(CNo!=0)
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
			ps=con.prepareStatement("select * from personnel");
			rs=ps.executeQuery();
			queryResult.append("<table class=altrowstable id=alternatecolor>");
				queryResult.append("<tr>");
				queryResult.append("<th>ID</th>");
				queryResult.append("<th>Name</th>");
				queryResult.append("<th>Sex</th>");
				queryResult.append("<th>Work_year</th>");
				queryResult.append("<th>Salary</th>");
				queryResult.append("</tr>");
		while(rs.next()){
			if(rs.getString(2)!=null) {
			queryResult.append("<tr>");
				queryResult.append("<td>"+rs.getString(1)+"</td>");
				queryResult.append("<td>"+rs.getString(2)+"</td>");
				queryResult.append("<td>"+rs.getString(3)+"</td>");
				queryResult.append("<td>"+rs.getString(4)+"</td>");
				queryResult.append("<td>"+rs.getString(5)+"</td>");
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
		    String selectSql="select * from personnel where 1=1 ";
			if(CN!=null&&CN.length()>0){
				selectSql=selectSql+" and Name='"+CN+"' ";
			}
			if(TN>0){
				selectSql=selectSql+" and Work_year>"+TN+" ";
			}
			if(PR>0){
				selectSql=selectSql+" and Salary>"+PR+" ";
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
				queryPrepareResultBy.append("<th>Sex</th>");
				queryPrepareResultBy.append("<th>Work_year</th>");
				queryPrepareResultBy.append("<th>Salary</th>");
				queryPrepareResultBy.append("</tr>");
				
			while(rs.next()){
				queryPrepareResultBy.append("<tr>");
				queryPrepareResultBy.append("<td>"+rs.getString(1)+"</td>");
				queryPrepareResultBy.append("<td>"+rs.getString(2)+"</td>");
				queryPrepareResultBy.append("<td>"+rs.getString(3)+"</td>");
				queryPrepareResultBy.append("<td>"+rs.getString(4)+"</td>");
				queryPrepareResultBy.append("<td>"+rs.getString(5)+"</td>");
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