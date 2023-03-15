package com.entity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Teachers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	private String name;
	
	private int age;

	@OneToMany
	@JoinColumn(name = "TeacherID")		// this annotation is use to link fk in student table 
	private Set<Class> listOfClasses;	
	


	public Set<Class> getListOfClasses() {
		return listOfClasses;
	}

	public void setListOfClasses(Set<Class> listOfClasses) {
		this.listOfClasses = listOfClasses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
