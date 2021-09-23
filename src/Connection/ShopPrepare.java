package Connection;


import java.sql.*;
public class ShopPrepare {
	int CNo;
    String CN;
    int  TN;
    String KKXQ;
    String CT;
    String SC;
    int FL;
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
	public int getFL() {
		return FL;
	}
	public void setFL(int FL) {
		this.FL = FL;
	}
	public String getKKXQ() {
		return KKXQ;
	}
	public void setKKXQ(String KKXQ) {
		this.KKXQ = KKXQ;
	}
	public String getCT() {
		return CT;
	}
	public void setCT(String CT) {
		this.CT = CT;
	}
	public String getSC() {
		return SC;
	}
	public void setSC(String SC) {
		this.SC = SC;
	}
	public double getPR() {
		return PR;
	}
	public void setPR(double PR) {
		this.PR = PR;
	}
	//添加数据
    public void addShops(){
    	Connection con = null;
    	PreparedStatement ps = null;
    	PreparedStatement ps1 = null;
		
		String floor = null;
    	switch(FL) {
    	case 1: floor="First";break;
    	case 2: floor="Second";break;
    	case 3: floor="Third";break;
    	}
    	String add = floor+" floor,"+" No."+KKXQ;
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			ps=con.prepareStatement("insert into shops (`idshops`, `Name`, `Tel`, `Address`)  values(?,?,?,?)");
			ps.setInt(1, CNo);
			ps.setString(2, CN);	
			ps.setInt(3, TN);
			ps.setString(4, add);
			ps.executeUpdate();
			
			ps1=con.prepareStatement("insert into shop_address ( `Address`, `Type`,`Capacity`,`Floor`,`Number`)  values(?,?,?,?,?)");
			ps1.setString(1, add);
			ps1.setString(2, CT);
			ps1.setDouble(3, PR);
			ps1.setInt(4, FL);
			ps1.setString(5, KKXQ);
			ps1.executeUpdate();
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
    public int editShops(){
    	Connection con = null;
    	PreparedStatement ps = null;
    	PreparedStatement ps1 = null;
    	PreparedStatement ps2 = null;
    	String floor = null;
    	switch(FL) {
    	case 1: floor="First";break;
    	case 2: floor="Second";break;
    	case 3: floor="Third";break;
    	}
    	String add = floor+" floor,"+" No."+KKXQ;
    	if(CN!=null&&CT!=null&&KKXQ!=null&&TN!=0&&PR!=0) {
    		try {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    		try {
    			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
    			
    		
    			ps2=con.prepareStatement("update shops set  `Name`=?, `Tel`=?, `Address`=?  where idshops = "+CNo);
			
    			ps2.setString(1, CN);	
    			ps2.setInt(2, TN);
    			ps2.setString(3, add);
    			ps2.executeUpdate();
    			
    			ps1=con.prepareStatement("update shop_address set  `Type`=?, `Capacity`=? , `Floor`=? , `Number`=?  where Address = '"+add+"'");
    			ps1.setString(1, CT);
    			ps1.setDouble(2, PR);
    			ps1.setInt(3, FL);
    			ps1.setString(4, KKXQ);
    			ps1.executeUpdate();
    			
    
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
    	if(CN!=null||CT!=null||KKXQ!=null||TN!=0||PR!=0||FL!=0){
    		return 0;
    		}
    	return -1;
    }
    
    //修改数据
    public void deleteShops(){
    	Connection con = null;

    	PreparedStatement ps = null;
   
   
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		 	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false","root","root");
			
			
			if(CNo!=0) {
		
			
			ps=con.prepareStatement("delete from shops where idshops="+CNo);
			ps.executeUpdate();
			}
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
			ps=con.prepareStatement("SELECT idshops, Name, Tel, a.Address,Type,Capacity,Allowable_least_Cap FROM shops  a join shop_address  b where a.Address = b.Address order by idshops");
			rs=ps.executeQuery();
			queryResult.append("<table class=altrowstable id=alternatecolor>");
				queryResult.append("<tr>");
				queryResult.append("<th>ID</th>");
				queryResult.append("<th>Name</th>");
				queryResult.append("<th>TEL</th>");
				queryResult.append("<th>Address</th>");
				queryResult.append("<th>Type</th>");
				queryResult.append("<th>Current_Capacity</th>");
				queryResult.append("<th>Allowable_least_Capacity</th>");
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
		    String selectSql="select  idshops, Name, Tel, a.Address,Type,Capacity,Allowable_least_Cap from shops  a join shop_address b where a.Address = b.Address";
		    if(CNo>0){
				selectSql=selectSql+" and idshops='"+CNo+"' ";
			}
			if(KKXQ!=null&&KKXQ.length()>0){
				selectSql=selectSql+" and Name='"+KKXQ+"' ";
			}
			if(PR>0){
				selectSql=selectSql+" and Capacity>"+PR+" ";
			}
			if(CN!=null&&CN.length()>0){
				selectSql=selectSql+" and Type='"+CN+"'  order by idshops ";
			}
			ps=con.prepareStatement(selectSql);
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