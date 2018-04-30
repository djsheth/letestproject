package rameshmain;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class JdbcConnectionDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
String connectionUrl = "jdbc:sqlserver://localhost:1433;"+"databaseName=Dhaval;integratedSecurity=true;";
Connection con = null;
Statement stmt = null;
ResultSet rs = null;


	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(connectionUrl);
		System.out.println("Connection Established");
		String SQL = "SELECT * from Marksheet";
		stmt = con.createStatement();
		rs = stmt.executeQuery(SQL);
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	
		
	}




}
	


	
