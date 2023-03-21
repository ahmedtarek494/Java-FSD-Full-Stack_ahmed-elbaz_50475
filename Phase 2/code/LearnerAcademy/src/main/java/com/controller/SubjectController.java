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

import com.entity.Subject;
import com.service.SubjectService;

/**
 * Servlet implementation class Subject
 */
@WebServlet("/Subject")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("subjects.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		String sname = request.getParameter("name");
		String slevel = request.getParameter("level");
		
		Subject subject=new Subject();
		subject.setName(sname);
		subject.setLevel(slevel);
		
		SubjectService service=new SubjectService();
		
		String result=service.storeSubject(subject);
		pw.println(result);
		doGet(request, response);
	}

}
