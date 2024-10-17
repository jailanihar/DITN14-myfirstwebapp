package com.nep.myfirstwebapp.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="groups_spring")
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	@Column(nullable=false, length=6, unique=true)
	String groupCode;
	@Column(nullable=false)
	String programmeName;
	@OneToMany(
			fetch=FetchType.LAZY,
			mappedBy="groupPB",
			cascade=CascadeType.ALL
			)
	Set<Student> students;
	
	public Group() {}

	public Group(String groupCode, String programmeName) {
		super();
		this.groupCode = groupCode;
		this.programmeName = programmeName;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getProgrammeName() {
		return programmeName;
	}

	public void setProgrammeName(String programmeName) {
		this.programmeName = programmeName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public long getId() {
		return id;
	}
	
}
