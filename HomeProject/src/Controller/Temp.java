package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.LoginBeanClass;

/**
 * Servlet implementation class Temp
 */
@WebServlet("/Temp")
public class Temp extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean(request, response);
	
	}
	
	protected void UserBean(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		
		LoginBeanClass bean= (LoginBeanClass) request.getAttribute("Bean");
		bean.setUserName(request.getParameter("UserName"));
		bean.setPassword(request.getParameter("Password"));		
	
		System.out.println(bean.getPassword());
		System.out.println(bean.getUserName());
       
	}



}

