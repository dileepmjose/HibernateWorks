package com.djose.hiberante.mapping.onetoone;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true, nullable = false, length = 10)
	private int userId;

	@Column(name = "USER_NAME", unique = true, nullable = false, length = 10)
	private String userName;

	@OneToOne(mappedBy="user")
	private Vechicle vechicles;

	public Vechicle getVechicles() {
		return vechicles;
	}

	public void setVechicles(Vechicle vechicles) {
		this.vechicles = vechicles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
