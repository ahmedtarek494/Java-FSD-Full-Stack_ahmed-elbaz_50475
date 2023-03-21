package com.service;

import java.util.List;

import com.dao.SubjectDao;
import com.entity.Subject;

public class SubjectService {

	
	SubjectDao subjectDao= new SubjectDao();
	
	public String storeSubject(Subject subject) {
		
	int result= subjectDao.save(subject);
	
	if(result==1) {
		return "Subject added successfully";
	}
	else {
		return "Subject adding failed, Please try again later";
	}
	}
	
	public List<Subject> getAllSubjects(){
		return subjectDao.findAll();
	}
}
