package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Class;
import com.entity.Student;
import com.service.ClassService;

/**
 * Servlet implementation class ReportController
 */
@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */List<Class> classes;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassService service3=new ClassService();
		 classes=service3.getAllClasss();
		request.setAttribute("listOfClasses", classes);
		RequestDispatcher rd = request.getRequestDispatcher("report.jsp");
		rd.include(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		
		int classId = Integer.parseInt(request.getParameter("class"));
		ClassService service3=new ClassService();
		try {
		Class selectedClass= service3.getSelectedClass(classes, classId);
		Set<Student> students=selectedClass.getStudents();
		request.setAttribute("selectedClass", selectedClass);
		request.setAttribute("listOfStudents", students);
		}catch(Exception e) {
			e.printStackTrace();
			pw.println("Wrong Class");
		}
		doGet(request, response);
	}

}
