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
		    
		    String sql="insert into dept(SNO,Name,Age,College) values ('s001','�ϴ�',20,'�����ѧԺ')";
		    stmt.executeUpdate(sql);
		    sql="insert into dept(SNO,Name,Age,College) values ('s002','�϶�',19,'�����ѧԺ')";
		    stmt.executeUpdate(sql);
		    sql="insert into dept(SNO,Name,Age,College) values ('s003','����',18,'�����ѧԺ')";
		    stmt.executeUpdate(sql);
		    sql="insert into dept(SNO,Name,Age,College) values ('s004','����',17,'�����ѧԺ')";
		    stmt.executeUpdate(sql);
		    sql="insert into dept(SNO,Name,Age,College) values ('s004','����',17,'�����ѧԺ')";
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
		    
		    sql="update Student set SNO='s001',Name='�ϴ�',Age=20,College='ͨ��ѧԺ' where SNO = s001";
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
