package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dbconnection;
import bean.User;

@WebServlet("/edit")
public class Editserv extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Edit(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Edit(request,response);
	
	}
	protected void Edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id=Integer.parseInt(request.getParameter("id"));
		ArrayList<User> al2=new ArrayList<User>();
		Dbconnection obj=new Dbconnection();
		al2=obj.edit(id);
		request.setAttribute("data", al2);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
