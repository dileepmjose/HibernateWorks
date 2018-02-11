package com.djose.hiberante.basic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML.Attribute;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.djose.hiberante.inheritance.Circle;
import com.djose.hiberante.inheritance.Rectangle;
import com.djose.hiberante.inheritance.Shape;
import com.djose.hiberante.mapping.manytomany.Student;
import com.djose.hiberante.mapping.manytomany.Subject;
import com.djose.hiberante.mapping.onetomany.Country;
import com.djose.hiberante.mapping.onetomany.State;
import com.djose.hiberante.mapping.onetoone.User;
import com.djose.hiberante.mapping.onetoone.Vechicle;
import com.djose.hiberante.util.HibernateUtil;
import com.djose.hiberante.util.Utils;

public class HibernateInheritanceTest {
	
	
	
		
	 @Before
	 public  void intialize(){
		
	 }
	 
	 @Test
	 public void t1_InheritanceSingletableTest(){
			Session session = HibernateUtil.openHiberanteSession();
			Utils.printMessage("Inheritance Single table");			
			
			Shape shape = new Shape();
			shape.setShapeName("Square");
			
			Rectangle rectangle = new Rectangle("Rectangle", 10, 20);
			Circle circle = new Circle("Circle", 4);

			session.save(shape);
			session.save(rectangle);
			session.save(circle);

			HibernateUtil.ClosingHiberanteSession(session);					
			Utils.printMessage(" --------------------------");	
	 }
		
	 
	
	
	
	@After
	public  void destory(){
		
	 }
	

}
