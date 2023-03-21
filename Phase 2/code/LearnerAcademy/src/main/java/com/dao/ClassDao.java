package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.entity.Teachers;
import com.entity.Class;
import com.resource.DbResource;

public class ClassDao {

	SessionFactory sf;

	public ClassDao() {
		sf = DbResource.getSessionFactory();
	}

	public int save(Class classObj) {
		try {
			Session session = sf.openSession();

			Transaction tr = session.getTransaction();

			tr.begin();

			session.save(classObj);
			tr.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Class> findAll() {
		Session session = sf.openSession();
		TypedQuery<Class> tq = session.createQuery("from Class");
		List<Class> listOfClasses = tq.getResultList();
		return listOfClasses;
	}

	public int updateSubjectOrTeacher(Class classObj) {
		
			Session session = sf.openSession();
			Transaction tr = session.getTransaction();
			Class p = session.get(Class.class, classObj.getId());
			if(p==null) {
				return 0;
			}else {
				tr.begin();
					p.setSubjectId(classObj.getSubjectId());
					p.setTeacherId(classObj.getTeacherId());
					session.update(p);
				tr.commit();
				return 1;
			}	
	}
	
	public static void main(String[] args) {

	}

}
