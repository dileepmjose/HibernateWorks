package com.djose.hiberante.mapping.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="COUNTRY")
public class Country implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5783721086122059416L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;	
	
	@OneToMany(mappedBy="countries")
	private Collection<State> states = new ArrayList<State>();
	
	
	
	public Collection<State> getStates() {
		return states;
	}

	public void setStates(Collection<State> states) {
		this.states = states;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
