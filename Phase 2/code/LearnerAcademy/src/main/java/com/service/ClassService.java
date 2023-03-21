package com.service;

import java.util.List;

import com.dao.ClassDao;
import com.entity.Class;

public class ClassService {


	ClassDao classDao= new ClassDao();
	
	public String storeClass(Class classObj) {
		
	int result= classDao.save(classObj);
	
	if(result==1) {
		return "Class added successfully";
	}
	else {
		return "Class adding failed, Please try again later";
	}
	}
	
	public String updateClass(Class classObj) {
		
		int result= classDao.updateSubjectOrTeacher(classObj);
		
		if(result==1) {
			return "Class Updated successfully";
		}
		else {
			return "Class Updating failed, Please try again later";
		}
		}
	public Class getSelectedClass(List<Class> classes,int classID) {
		
		Class classobj = null;
		
		for(Class temp:classes) {
			if(temp.getId()==classID)
				classobj=temp;
		}
		
	return classobj;
		}
	public List<Class> getAllClasss(){
		return classDao.findAll();
	}
}
