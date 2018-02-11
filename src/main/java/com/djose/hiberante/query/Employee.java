package com.djose.hiberante.query;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY, region="Employee_Cache")
@Table(name = "EMPLOYEE")
@NamedQuery(name = "findByGender", query = "from Employee where gender= :gender ")
@NamedNativeQueries({
		@NamedNativeQuery(name = "findEmployeeByLastName", query = "SELECT EMP_ID, FIRST_NAME, LAST_NAME,GENDER, DATE_OF_BIRTH"
				+ " FROM EMPLOYEE " + " WHERE FIRST_NAME = :fname ", resultClass = Employee.class),
		@NamedNativeQuery(name = "findEmployeeByFirstNameCity", query = "select emp.EMP_ID ,emp.FIRST_NAME,emp.LAST_NAME,ad.CITY,emp.GENDER,emp.DATE_OF_BIRTH from employee emp join "
				+ " address ad on emp.EMP_ID = ad.EMP_ID where ad.CITY = :city and emp.FIRST_NAME = :fname ", resultClass = Employee.class) })
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5884476314402919269L;

	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private Integer employeId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DATE_OF_BIRTH")
	private Date dob;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Address> address;

	public Integer getEmployeId() {
		return employeId;
	}

	public void setEmployeId(Integer employeId) {
		this.employeId = employeId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Collection<Address> getAddress() {
		return address;
	}

	public void setAddress(Collection<Address> address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
