package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.entity.Teachers;
import com.resource.DbResource;

public class SubjectDao {

	static SessionFactory sf;
	public SubjectDao() {			
		sf = DbResource.getSessionFactory();
	}
	public static int save(){
	try {	
	Session session=sf.openSession();
	
	Transaction tr=session.getTransaction();
	
	tr.begin();
	
	Subject s= new Subject();
	s.setName("English");
	s.setLevel("2");
	 session.save(s);
	 tr.commit();
		return 1;}
	catch(Exception e) {
		return 0;
	}
	
	
	}
	
	public static void main(String[]args) {
		
		SubjectDao t= new SubjectDao();
		
		System.out.println("Size : "+t.save());
	}
}
