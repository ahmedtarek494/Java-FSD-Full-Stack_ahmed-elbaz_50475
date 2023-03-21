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

import com.entity.Class;
import com.entity.Student;
import com.entity.Subject;
import com.service.ClassService;
import com.service.StudentService;
import com.service.SubjectService;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		StudentService service=new StudentService();
		List<Student> students=service.getAllStudents();
		
		request.setAttribute("listOfStudents", students);
		ClassService service3=new ClassService();
		List<Class> classes=service3.getAllClasss();
		request.setAttribute("listOfClasses", classes);
		RequestDispatcher rd = request.getRequestDispatcher("students.jsp");
		rd.include(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		String sname = request.getParameter("name");
		int classId = Integer.parseInt(request.getParameter("class"));
		
		Student student=new Student();
		student.setName(sname);
		Class classObj=new Class();
		classObj.setId(classId);
		student.setClassId(classObj);;
		
		StudentService service=new StudentService();
		
		String result=service.storeStudent(student);
		pw.println(result);
		doGet(request, response);
	}

}
