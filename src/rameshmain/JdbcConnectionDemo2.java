package rameshmain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionDemo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Driver Loaded");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433/Dhaval;");
		System.out.println("Connection Established");
		/*String SQL = "SELECT * from Marksheet";
		stmt = con.createStatement();
		rs = stmt.executeQuery(SQL);
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
	*/
		
	
		
	}




}
	


	
