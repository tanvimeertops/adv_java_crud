package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Student;
import com.dao.StudentDao;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//to get value
		String action=request.getParameter("action");
		//action=Insert
	 if(action.equalsIgnoreCase("Insert")) {
//System.out.println("Insert Clicked!!!");
//System.out.println("first name :"+request.getParameter("fname"));
//System.out.println("Last name :"+request.getParameter("lname"));
//System.out.println("Email :"+request.getParameter("email"));
//System.out.println("Mobile :"+request.getParameter("mobile"));
//System.out.println("Address :"+request.getParameter("address"));
//System.out.println("Gender :"+request.getParameter("gender"));
		Student s=new Student();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(request.getParameter("mobile"));
			s.setAddress(request.getParameter("address"));
			s.setGender(request.getParameter("gender"));
		
			StudentDao.insertStudent(s);
			response.sendRedirect("show.jsp");
	 }
	 else if (action.equalsIgnoreCase("Edit")) {
		System.out.println("Edit clicked...");
	int id=Integer.parseInt(request.getParameter("id"))	;
	try {
		Student s= StudentDao.getAllStudentById(id);
		request.setAttribute("s", s);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	} if(action.equalsIgnoreCase("update")) {
		//System.out.println("Insert Clicked!!!");
		//System.out.println("first name :"+request.getParameter("fname"));
		//System.out.println("Last name :"+request.getParameter("lname"));
		//System.out.println("Email :"+request.getParameter("email"));
		//System.out.println("Mobile :"+request.getParameter("mobile"));
		//System.out.println("Address :"+request.getParameter("address"));
		//System.out.println("Gender :"+request.getParameter("gender"));
				Student s=new Student();
					s.setId(Integer.parseInt(request.getParameter("id")) );
					s.setFname(request.getParameter("fname"));
					s.setLname(request.getParameter("lname"));
					s.setEmail(request.getParameter("email"));
					s.setMobile(request.getParameter("mobile"));
					s.setAddress(request.getParameter("address"));
					s.setGender(request.getParameter("gender"));
				
					StudentDao.updateStudent(s);
					response.sendRedirect("show.jsp");
			 }
	
	else if (action.equalsIgnoreCase("delete")) {
		System.out.println("delete clicked...");
	int id=Integer.parseInt(request.getParameter("id"))	;
	try {
		Student s= StudentDao.deleteStudentById(id);
		response.sendRedirect("show.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
	}

}
