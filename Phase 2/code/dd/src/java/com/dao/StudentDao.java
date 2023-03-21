package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Class;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teachers;
import com.resource.DbResource;

public class StudentDao {


	static SessionFactory sf;
	public StudentDao() {			
		sf = DbResource.getSessionFactory();
	}
	public static int save(){
	try {	
	Session session=sf.openSession();
	
	Transaction tr=session.getTransaction();
	
	tr.begin();
	Class c= new Class();
	c.setId(3);
	
	
	Student s= new Student();
	s.setName("john");
	s.setGrade("30");
	s.setClassId(c);
	
	 session.save(s);
	 tr.commit();
		return 1;}
	catch(Exception e) {
		e.printStackTrace();
		return 0;
	}
	
	
	}
	
	public static void main(String[]args) {
		
		StudentDao t= new StudentDao();
		
		System.out.println("Size : "+t.save());
	}
}
