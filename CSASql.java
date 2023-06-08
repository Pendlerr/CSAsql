package csaSql;
import java.sql.*;

public class CSASql {
	
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Driver driver=new com.mysql.jdbc.Driver();
		    DriverManager.registerDriver(driver);
		    String url="jdbc:mysql://127.0.0.1:3306/bjpowernode";
		    String user="root";
		    String password="root";
		    conn=DriverManager.getConnection(url,user,password);
		    
		    stmt=conn.createStatement();
		    
		    String sql="insert into dept(SNO,Name,Age,College) values ('s001','老大',20,'计算机学院')";
		    stmt.executeUpdate(sql);
		    sql="insert into dept(SNO,Name,Age,College) values ('s002','老二',19,'计算机学院')";
		    stmt.executeUpdate(sql);
		    sql="insert into dept(SNO,Name,Age,College) values ('s003','老三',18,'计算机学院')";
		    stmt.executeUpdate(sql);
		    sql="insert into dept(SNO,Name,Age,College) values ('s004','老四',17,'计算机学院')";
		    stmt.executeUpdate(sql);
		    sql="insert into dept(SNO,Name,Age,College) values ('s004','老四',17,'计算机学院')";
		    stmt.executeUpdate(sql);

		    sql="select * from Student";
		    rs=stmt.executeQuery(sql);
		    while(rs.next()) {
		    	System.out.print(rs.getString(1));
		    	System.out.print(rs.getString(2));
		    	System.out.print(rs.getString(3));
		    	System.out.println(rs.getString(4));
		    }
		    
		    sql="delete from Student where SNO='s004'";
		    stmt.executeUpdate(sql);
		    
		    sql="select * from Student where SNO=s003";
		    rs=stmt.executeQuery(sql);
		    if(rs.next()) {
		    	System.out.print(rs.getString(1));
		    	System.out.print(rs.getString(2));
		    	System.out.print(rs.getString(3));
		    	System.out.println(rs.getString(4));
		    }
		    
		    sql="update Student set SNO='s001',Name='老大',Age=20,College='通信学院' where SNO = s001";
		    stmt.executeUpdate(sql);
		    
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
			if(stmt!=null) {
				stmt.close();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
			if(conn!=null) {
				conn.close();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
			if(rs!=null) {
				rs.close();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
