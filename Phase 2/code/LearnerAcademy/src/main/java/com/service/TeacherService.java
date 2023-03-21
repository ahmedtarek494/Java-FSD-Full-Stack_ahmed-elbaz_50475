package com.service;

import java.util.List;

import com.dao.TeachersDao;
import com.entity.Teachers;

public class TeacherService {


	TeachersDao teacherDao= new TeachersDao();
	
	public String storeTeacher(Teachers teacher) {
		
		int result= teacherDao.save(teacher);
	
	if(result==1) {
		return "Teacher added successfully";
	}
	else {
		return "Teacher adding failed, Please try again later";
	}
	}
	
	public List<Teachers> getAllTeachers(){
		return teacherDao.findAll();
	}
}
