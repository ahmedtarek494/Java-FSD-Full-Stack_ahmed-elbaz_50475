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
import com.entity.Subject;
import com.entity.Teachers;
import com.service.ClassService;
import com.service.SubjectService;
import com.service.TeacherService;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		SubjectService service=new SubjectService();
		List<Subject> subjects=service.getAllSubjects();
		request.setAttribute("listOfSubjects", subjects);
		TeacherService service2=new TeacherService();
		List<Teachers> teachers=service2.getAllTeachers();
		request.setAttribute("listOfTeachers", teachers);
		
		ClassService service3=new ClassService();
		List<Class> classes=service3.getAllClasss();
		request.setAttribute("listOfClasses", classes);
		RequestDispatcher rd = request.getRequestDispatcher("editClasses.jsp");
		rd.include(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		int classId = Integer.parseInt(request.getParameter("class"));
		int subjectId = Integer.parseInt(request.getParameter("subject"));
		int teacherId = Integer.parseInt(request.getParameter("teacher"));

		Subject subject=new Subject();
		subject.setId(subjectId);
		
		Teachers teacher= new Teachers();
		teacher.setId(teacherId);
		
		Class classObj=new Class();
		classObj.setId(classId);
		classObj.setSubjectId(subject);
		classObj.setTeacherId(teacher);
		
		ClassService service3=new ClassService();
		
		String result=service3.updateClass(classObj);
		pw.println(result);
		doGet(request, response);
	}

}
