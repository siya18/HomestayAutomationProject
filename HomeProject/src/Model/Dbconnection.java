package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.User;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Dbconnection {
	  
	Connection c=null;
	int i,y;
	ArrayList<User> al = new ArrayList<User>();
	ArrayList<User> al2 = new ArrayList<User>();
	
	public Connection Dbcon()
	{  
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			c=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/studentinformation", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
		
	}

	public int  insert(User u) {
		c= Dbcon();
		
		
		try {
			PreparedStatement ps=(PreparedStatement) c.prepareStatement("insert into information1 values(null,?,?,?,?,?,?,?)");
			ps.setString(1,u.getFname());
			ps.setString(2, u.getUname());
			ps.setString(3, u.getPass());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getGender());
			ps.setString(6, u.getCourse());
			ps.setString(7, u.getHob());
			 i=ps.executeUpdate();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<User> select() {
		c=Dbcon();
		Statement st=null;
	try {
		st=(Statement) c.createStatement();
		ResultSet rs=st.executeQuery("select * from information1");
		while(rs.next())
		{
			User u =new User();
			u.setId(rs.getInt(1));
			u.setFname(rs.getString(2));
			u.setUname(rs.getString(3));
			u.setPass(rs.getString(4));
			u.setAge(rs.getInt(5));
			u.setGender(rs.getString(6));
			u.setCourse(rs.getString(7));
			u.setHob(rs.getString(8));
			
			al.add(u);
			
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return al;
	}

	public ArrayList<User> edit(int id) {
		c= Dbcon();
		try {
			Statement st=(Statement) c.createStatement();
			ResultSet rs=st.executeQuery("select * from information1 where id="+id+" "  );
			while( rs.next())
			{
				User u=new User();
				u.setId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setUname(rs.getString(3));
				u.setPass(rs.getString(4));
				u.setAge(rs.getInt(5));
				u.setGender(rs.getString(6));
				u.setCourse(rs.getString(7));
				u.setHob(rs.getString(8));
				
				al2.add(u);
				
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		
	}
		return al2;

}

	public int update(User u) {
		c= Dbcon();
		try {
			
			PreparedStatement ps=(PreparedStatement) c.prepareStatement("update information1 set name=?,username=? ,password=?,age=?,gender=?,course=?,hobbies=? where id= " +u.getId()+"  ");
			ps.setString(1,u.getFname());
			ps.setString(2,u.getUname());
			ps.setString(3,u.getPass());
			ps.setInt(4,u.getAge());
			ps.setString(5,u.getGender());
			
			ps.setString(6,u.getCourse());
			ps.setString(7,u.getHob());
			 i=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int delete(int id) {
		c= Dbcon();
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) c.prepareStatement("delete from information1 where id = "+id+"  ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			 i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
}
