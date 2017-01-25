package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DatabaseActions;
import Model.DatabaseConnection;
import Model.LoginBeanClass;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginMethod(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginMethod(request, response);
	
	}
	
	
	protected void LoginMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String UserName=request.getParameter("UserName");
		String Password=request.getParameter("Password");
		
		LoginBeanClass Bean= new LoginBeanClass();
		Bean.setPassword(Password);
		Bean.setUserName(UserName);
	
		/*request.setAttribute("Bean", Bean);
		request.getRequestDispatcher("/Temp").forward(request,response);*/
		
		
		
		DatabaseConnection dbc= new DatabaseConnection();
		dbc.Connect();
		
		DatabaseActions objDA= new DatabaseActions();
		/*objDA.Insert(DatabaseConnection.conn, Bean);
		objDA.Select(DatabaseConnection.conn);*/
		
		//objDA.Delete(DatabaseConnection.conn);
		objDA.Update(DatabaseConnection.conn);
		
		


}
	
}
