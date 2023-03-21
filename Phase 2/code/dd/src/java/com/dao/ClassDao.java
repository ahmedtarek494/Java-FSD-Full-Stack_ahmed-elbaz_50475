package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.entity.Teachers;
import com.entity.Class;
import com.resource.DbResource;

public class ClassDao {
	

	static SessionFactory sf;
	public ClassDao() {			
		sf = DbResource.getSessionFactory();
	}
	public static int save(){
	try {	
	Session session=sf.openSession();
	
	Transaction tr=session.getTransaction();
	
	tr.begin();
	Teachers t= new Teachers();
	t.setId(1);
	Subject s= new Subject();
	s.setId(1);
	
	Class c= new Class();
	c.setName("Class A");
	c.setSubjectId(s);
	c.setTeacherId(t);
	
	 session.save(c);
	 tr.commit();
		return 1;}
	catch(Exception e) {
		e.printStackTrace();
		return 0;
	}
	
	
	}
	
	public static void main(String[]args) {
		
		ClassDao t= new ClassDao();
		
		System.out.println("Size : "+t.save());
	}

}
