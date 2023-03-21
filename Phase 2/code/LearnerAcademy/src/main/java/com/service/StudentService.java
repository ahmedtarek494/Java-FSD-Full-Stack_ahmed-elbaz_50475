package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.entity.Student;

public class StudentService {

StudentDao studentDao= new StudentDao();
	
	public String storeStudent(Student student) {
		
	int result= studentDao.save(student);
	
	if(result==1) {
		return "Student added successfully";
	}
	else {
		return "Student adding failed, Please try again later";
	}
	}
	
	public List<Student> getAllStudents(){
		return studentDao.findAll();
	}
}
