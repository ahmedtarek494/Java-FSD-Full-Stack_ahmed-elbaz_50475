package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Teachers;
import com.resource.DbResource;

public class TeachersDao {

	
	static SessionFactory sf;
	public TeachersDao() {			
		sf = DbResource.getSessionFactory();
	}
	public static List<Teachers> findAll(){
		
	Session session=sf.openSession();
	
	Transaction tr=session.getTransaction();
	
	tr.begin();
	
	TypedQuery<Teachers> tq = session.createQuery("from Teachers");
	List<Teachers> listOfTeachers = tq.getResultList();
	
	return listOfTeachers;
	
	}
	
	public static void main(String[]args) {
		
		TeachersDao t= new TeachersDao();
		List<Teachers> listOfTeachers =t.findAll();
		System.out.println("Size : "+listOfTeachers.size());
	}
}
