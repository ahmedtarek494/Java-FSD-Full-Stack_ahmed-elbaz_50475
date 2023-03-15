package com.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Class {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	private String name;
	
	@OneToOne
	private Teachers teacherId;
	
	@OneToOne
	private Subject subjectId;
	
	@OneToMany
	@JoinColumn(name = "ClassID")	
	private Set<Student> students;

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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

	public Teachers getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Teachers teacherId) {
		this.teacherId = teacherId;
	}

	public Subject getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}
	
}
