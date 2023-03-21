package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Class;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teachers;
import com.resource.DbResource;

public class StudentDao {

	SessionFactory sf;

	public StudentDao() {
		sf = DbResource.getSessionFactory();
	}

	public int save(Student student) {
		try {
			Session session = sf.openSession();

			Transaction tr = session.getTransaction();

			tr.begin();

			session.save(student);
			tr.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public List<Student> findAll(){
		Session session = sf.openSession();
		TypedQuery<Student> tq = session.createQuery("from Student");
		List<Student> listOfStudents = tq.getResultList();
		return listOfStudents;
		
	}
}
