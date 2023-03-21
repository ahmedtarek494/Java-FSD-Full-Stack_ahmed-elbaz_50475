package com.dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.resource.DbResource;

public class SubjectDao {

	SessionFactory sf;

	public SubjectDao() {
		sf = DbResource.getSessionFactory();
	}

	public int save(Subject subject) {
		try {
			Session session = sf.openSession();

			Transaction tr = session.getTransaction();

			tr.begin();

			session.save(subject);
			tr.commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	public List<Subject> findAll(){
		Session session = sf.openSession();
		TypedQuery<Subject> tq = session.createQuery("from Subject");
		List<Subject> listOfSubject = tq.getResultList();
		return listOfSubject;
		
	}

	public static void main(String[]args) {
		
		SubjectDao t= new SubjectDao();
		
	//	System.out.println("Size : "+t.findAll());
	}
}
