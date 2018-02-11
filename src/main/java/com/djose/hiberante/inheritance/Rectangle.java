package com.djose.hiberante.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "R")
public class Rectangle extends Shape {
	
	private static final long serialVersionUID = 942427838467581228L;

	@Column(name = "RECTANGLE_LENGTH")
	int length;
	
	@Column(name = "Rectangle_BREADTH")
	int breadth;

	public Rectangle() {

	}

	public Rectangle(String shapeName, int length, int breadth) {
		super(shapeName);
		this.length = length;
		this.breadth = breadth;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	
	
}
