package com.djose.hiberante.mapping.onetomany;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="STATE")
public class State  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3286764956944840640L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STATE_ID")
	private Integer stateId;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country countries;
	

	public Country getCountries() {
		return countries;
	}

	public void setCountries(Country countries) {
		this.countries = countries;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	
	
	

}
