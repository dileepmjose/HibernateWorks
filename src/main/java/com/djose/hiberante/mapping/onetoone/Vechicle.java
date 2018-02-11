package com.djose.hiberante.mapping.onetoone;

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
@Table(name = "VECHICLE")
public class Vechicle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "VECHICLE_ID", unique = true, nullable = false, length = 10)
	int vechicleId;

	@Column(name = "VECHICLE_NAME", unique = true, nullable = false, length = 10)
	String vechicleName;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getVechicleId() {
		return vechicleId;
	}

	public void setVechicleId(int vechicleId) {
		this.vechicleId = vechicleId;
	}

	public String getVechicleName() {
		return vechicleName;
	}

	public void setVechicleName(String vechicleName) {
		this.vechicleName = vechicleName;
	}

}
