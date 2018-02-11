package com.djose.hiberante.inheritance;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.DiscriminatorType;

@Entity
@Table(name = "SHAPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Shape implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -111981453070927658L;
	
	@Id
	@GeneratedValue
	@Column(name = "SHAPE_ID")
	int shapeId;
	
	@Column(name = "SHAPE_NAME")
	String shapeName;

	public Shape() {
	}

	public Shape(String shapeName) {
		this.shapeName = shapeName;
	}

	public int getShapeId() {
		return shapeId;
	}

	public void setShapeId(int shapeId) {
		this.shapeId = shapeId;
	}

	public String getShapeName() {
		return shapeName;
	}

	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}

}
