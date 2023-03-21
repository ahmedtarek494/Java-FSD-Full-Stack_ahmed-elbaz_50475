package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Teachers;

import com.service.TeacherService;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		TeacherService service=new TeacherService();
		List<Teachers> teachers=service.getAllTeachers();
		
		request.setAttribute("listOfTeachers", teachers);
		RequestDispatcher rd = request.getRequestDispatcher("teachers.jsp");
		rd.include(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		String sname = request.getParameter("name");
		int sage = Integer.parseInt(request.getParameter("age"));
		
		Teachers teacher=new Teachers();
		teacher.setName(sname);
		teacher.setAge(sage);
		
		TeacherService service=new TeacherService();
		
		String result=service.storeTeacher(teacher);
		pw.println(result);
		doGet(request, response);
	}

}
