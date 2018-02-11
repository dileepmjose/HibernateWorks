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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="STUDENT")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -518335243991725453L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STUDENT_ID")
	private Integer studentId;
	
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	@ManyToMany(mappedBy="students")	
	private Collection<Subject> subject = new ArrayList <Subject>();

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Collection<Subject> getSubject() {
		return subject;
	}

	public void setSubject(Collection<Subject> subject) {
		this.subject = subject;
	}
	
}
