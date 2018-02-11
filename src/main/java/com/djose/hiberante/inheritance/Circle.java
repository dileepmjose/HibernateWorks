package com.djose.hiberante.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
public class Circle extends Shape {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1528480839370948382L;

	@Column(name = "CIRCLE_RADIUS")
	int radius;

	public Circle() {
	}

	public Circle(String shapeName, int radius) {
		super(shapeName);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
