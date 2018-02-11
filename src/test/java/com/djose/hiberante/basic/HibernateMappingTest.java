package com.djose.hiberante.basic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML.Attribute;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.djose.hiberante.mapping.manytomany.Student;
import com.djose.hiberante.mapping.manytomany.Subject;
import com.djose.hiberante.mapping.onetomany.Country;
import com.djose.hiberante.mapping.onetomany.State;
import com.djose.hiberante.mapping.onetoone.User;
import com.djose.hiberante.mapping.onetoone.Vechicle;
import com.djose.hiberante.util.HibernateUtil;
import com.djose.hiberante.util.Utils;

public class HibernateMappingTest {
	
	
	
		
	 @Before
	 public  void intialize(){
		
	 }
		
	 
	/*
	 * Saving one to one Mapping 
	 */
	@Test
	public void  t1_SavingOneToOneMapping(){	
		
		Session session = HibernateUtil.openHiberanteSession();
		Utils.printMessage("ONE TO ONE MAPPING ");			
		
		User user1 = new User();
		user1.setUserName("USER 1");
		
		User user2 = new User();
		user2.setUserName("USER 2");
		
		Vechicle vechicle1 = new Vechicle();
		vechicle1.setVechicleName("Car");
				
		Vechicle vechicle2 = new Vechicle();
		vechicle2.setVechicleName("Jeep");

		user1.setVechicles(vechicle1);
		vechicle1.setUser(user1);	
		
		user2.setVechicles(vechicle2);
		vechicle2.setUser(user2);
		
		session.save(user1);
		session.save(vechicle1);
		session.save(user2);
		session.save(vechicle2);		
		
		HibernateUtil.ClosingHiberanteSession(session);		
		
		Utils.printMessage(" --------------------------");
	}
	
	
	/*
	 * Saving one to many Mapping 
	 */
	@Test
	public void t2_SavingOneToManyMapping(){		
		
		Session session = HibernateUtil.openHiberanteSession();
		Utils.printMessage("ONE TO MANY MAPPING");			
		
		Country country1 = new Country();
		country1.setCountryName("USA");
		
		State state1 = new State();
		state1.setStateName("WA");		
		State state2 = new State();
		state2.setStateName("OR");
		
		List<State> countries = new ArrayList<State>();
		countries.add(state1);
		countries.add(state2);
		
		country1.setStates(countries);			
		state1.setCountries(country1);
		state2.setCountries(country1);
		
		session.save(country1);
		
		session.save(state1);
		session.save(state2);
		
		HibernateUtil.ClosingHiberanteSession(session);				
		Utils.printMessage(" --------------------------");
	}
	
	/*
	 * Saving many to many Mapping 
	 */
	@Test
	public void t3_SavingManyToManyMapping(){
		Session session = HibernateUtil.openHiberanteSession();
		Utils.printMessage("MANY TO MANY MAPPING");
		
		Student student1 = new Student();
		student1.setStudentName("Thomas");		
		Student student2 = new Student();
		student2.setStudentName("Tony");		
		
		Subject subject1 = new Subject();	
		subject1.setSubjectName("Maths");		
		
		Subject subject2 = new Subject();	
		subject2.setSubjectName("Physics");		
		
		List <Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);		
		
		List <Subject> subjects = new ArrayList<Subject>();
		subjects.add(subject1);
		subjects.add(subject2);
		
				
		subject1.setStudents(students);		
		subject2.setStudents(students);		
		
		student1.setSubject(subjects);		
		student2.setSubject(subjects);		
		
		session.save(student1);
		session.save(student2);
		session.save(subject1);
		session.save(subject2);
		
		HibernateUtil.ClosingHiberanteSession(session);			
		Utils.printMessage(" --------------------------");
		
	}
	
	
	
	@After
	public  void destory(){
		
	 }
	

}
