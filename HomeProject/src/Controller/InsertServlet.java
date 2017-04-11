package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dbconnection;
import bean.User;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Insert(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Insert(request,response);
	
	}
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("fname");
	String username=request.getParameter("uname");
	String password=request.getParameter("pass");
	String a=request.getParameter("age");
	int age=Integer.parseInt(a);
	String gender=request.getParameter("gender");
	String course=request.getParameter("course");
	String hobbies="";
	String[] hob=request.getParameterValues("hob");
	for(int i=0;i<hob.length;i++)
	{
		hobbies+=hob[i] + " ";
	}
	
	User u=new User();
	u.setFname(name);
	u.setUname(username);
	u.setPass(password);
	u.setAge(age);
	u.setGender(gender);
	u.setCourse(course);
	u.setHob(hobbies);
	
	
	Dbconnection obj=new Dbconnection();
	
	int i=obj.insert(u);
	if(i!=0){
		request.getRequestDispatcher("view").forward(request, response);
	}
	
	
	
	}

}
