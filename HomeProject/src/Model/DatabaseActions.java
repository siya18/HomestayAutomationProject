package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseActions {
	Statement st=null;

	public void Select(Connection connection)
	{
		
		try {
			st=connection.createStatement();
		ResultSet rs=	st.executeQuery("select * from Login");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void Insert(Connection connection, LoginBeanClass bean)
	{
		
		
		try {
			
			String UName=bean.getUserName();
			String password=bean.getPassword();
			st=connection.createStatement();
			PreparedStatement ps=connection.prepareStatement("insert into Login values(?,?)");
			ps.setString(1,UName);
			ps.setString(2, password);
			
			System.out.println(UName);
			System.out.println(password);
			
			
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void Delete(Connection connection)
	{
		try {
			st=connection.createStatement();
			st.execute("Delete from Login where UName='siya' ");
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void Update(Connection connection)
	{
		try {
			st=connection.createStatement();
			PreparedStatement ps=connection.prepareStatement("Update Login set password=?"+"where UName=?");
			ps.setString(1, "shivangi");
			ps.setString(2, "Mira");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
