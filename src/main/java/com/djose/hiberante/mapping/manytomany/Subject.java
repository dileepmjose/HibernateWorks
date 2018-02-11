package com.djose.hiberante.mapping.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT")
public class Subject  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6606095572394915369L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SUBJECT_ID")
	private Integer subjectId;
	
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	
	@ManyToMany
	@JoinTable(
			   name = "STUDENT_SUBJECT", 
			   joinColumns = @JoinColumn(name = "SUBJECT_ID"), 
			   inverseJoinColumns = @JoinColumn(name = "STUDENT_ID")
			 )
	private Collection<Student> students = new ArrayList <Student>();

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	
	
	
}
