package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dbconnection;

@WebServlet("/delete")
public class DeleteServ extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Delete(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Delete(request,response);
	}
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			int id = Integer.parseInt(request.getParameter("id"));
		
		Dbconnection obj = new Dbconnection();
		int i=obj.delete(id);
		if(i!=0)
		{
			request.getRequestDispatcher("view").forward(request, response);
		}
	
	}

}
