package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import Model.Dbconnection;

/**
 * Servlet implementation class Updateserv
 */
@WebServlet("/update")
public class Updateserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Update(request,response);}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Update(request,response);
		
	
	
	}
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id")) ;
		
		String name=request.getParameter("fname");
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		String a=request.getParameter("age");
		int age=Integer.parseInt(a);
		String gender=request.getParameter("gender");
		String course=request.getParameter("course");
		String hobbies="";
		String hob[]=request.getParameterValues("hob");
		for(int i=0 ; i<hob.length; i++)
		{
		    hobbies+=hob[i]+" ";   
		
		}
		User u=new User();
		u.setId(id);
		u.setFname(name);
		u.setUname(username);
		u.setPass(password);
		u.setAge(age);
		u.setGender(gender);
		u.setCourse(course);
		u.setHob(hobbies);
		
		
		Dbconnection obj=new Dbconnection();
		int i=obj.update(u);
		if( i!=0)
		{
			request.getRequestDispatcher("view").forward(request, response);
		}
	
	}

}
