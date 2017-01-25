package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	public static Connection conn=null;
	String user="USERTEST";
	String pa="usertest";
	String URL="jdbc:sqlserver://localhost;database=NDB;user= "+user+";password="+pa+" ";
	public Connection Connect()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(URL);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	
	
	

}
