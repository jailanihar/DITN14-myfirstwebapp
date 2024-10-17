package com.nep.myfirstwebapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="students_spring")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String fullName;
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn
	Group groupPB;
	
	public Student() {}

	public Student(String fullName, Group groupPB) {
		this.fullName = fullName;
		this.groupPB = groupPB;
	}

	public Group getGroupPB() {
		return groupPB;
	}

	public void setGroupPB(Group groupPB) {
		this.groupPB = groupPB;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getId() {
		return id;
	}
	
	

}
