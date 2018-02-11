package com.djose.hiberante.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import com.djose.hiberante.query.Address;
import com.djose.hiberante.query.Employee;
import com.djose.hiberante.util.HibernateUtil;
import com.djose.hiberante.util.Utils;

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HibernateCachingTest {

	@Before
	public void intialize() {
		
	}
	
	
	
	@Test
	public void t1_loadData(){
		
		Utils.printMessage("LOADING DATA EMPLOYEE , ADDRESS");				
		Session session = HibernateUtil.openHiberanteSession();			
		Employee employee = new Employee();
		employee.setFirstName("Georgi");
		employee.setLastName("Facello");
		employee.setGender("M");
		employee.setDob(Utils.formatDate("1985-10-20"));

		List<Address> address = new ArrayList<Address>();
		Address add1 = new Address();
		add1.setAddress1("47 MySakila Drive");
		add1.setAddress2("UNIT 201");
		add1.setCity("Arlington");
		add1.setState("WA");
		add1.setZip("98029");
		add1.setCountry("USA");
		address.add(add1);

		add1.setEmployee(employee);

		Address add2 = new Address();
		add2.setAddress1("192 SE Drive");
		add2.setAddress2("UNIT 8-100");
		add2.setCity("Atlanta");
		add2.setState("GA");
		add2.setZip("937827");
		add2.setCountry("USA");
		address.add(add2);
		employee.setAddress(address);

		add2.setEmployee(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("Mary");
		employee1.setLastName("SH");
		employee1.setGender("F");
		employee1.setDob(Utils.formatDate("1990-11-08"));

		List<Address> address1 = new ArrayList<Address>();
		Address add3 = new Address();
		add3.setAddress1("34 SKA Drive");
		add3.setAddress2("UNIT 39s");
		add3.setCity("Banglore");
		add3.setState("KA");
		add3.setZip("383927");
		add3.setCountry("INDIA");
		address1.add(add3);

		add3.setEmployee(employee1);

		Address add4 = new Address();
		add4.setAddress1("999 Road");
		add4.setAddress2("LT 7-100");
		add4.setCity("Mumbai");
		add4.setState("MA");
		add4.setZip("379272");
		add4.setCountry("INDIA");
		address1.add(add4);
		employee1.setAddress(address);
		add4.setEmployee(employee1);

		session.save(employee);
		session.save(add1);
		session.save(add2);

		session.save(employee1);
		session.save(add3);
		session.save(add4);
		
		HibernateUtil.ClosingHiberanteSession(session);				
		Utils.printMessage(" --------------------------");	
		
	}
	
	
   
	@Test
	public void t2_SecondLevelcacheTest() {
		Session session = HibernateUtil.openHiberanteSession();
		Utils.printMessage("SECOND LEVEL CACHE EXAMPLE");
		Employee emp = (Employee) session.get(Employee.class, new Integer(1));
		System.out.println("----Employee ----" + emp.getFirstName() + "-----"
				+ emp.getGender());
		HibernateUtil.ClosingHiberanteSession(session);
		Utils.printMessage("closing Connection");
		Utils.printMessage("Open new Connection--This time Loading data from second level cache");
		Session session1 = HibernateUtil.openHiberanteSession();
		Employee emp1 = (Employee) session1.get(Employee.class, new Integer(1));
		System.out.println("----Employee ----" + emp1.getFirstName() + "-----"
				+ emp1.getGender());
		HibernateUtil.ClosingHiberanteSession(session1);
		Utils.printMessage(" --------------------------");

	}
	
	@Test
	public void t3_QuerycacheTest() {
		Session session = HibernateUtil.openHiberanteSession();
		Utils.printMessage("QUERY CAHE EXAMPLE");
		Query query = session.createQuery("from Address");
		query.setCacheable(true);
		List<Address> addressList = query.list();
		for (Address ad1 : addressList) {
			System.out.println("----Address ----" + ad1.getCountry() + "-----"
					+ ad1.getCity());
		}
		HibernateUtil.ClosingHiberanteSession(session);
		Utils.printMessage("closing Connection");
		Utils.printMessage("Open new Coonection--This time Loading data from query cache");
		addressList.clear();
		Session session1 = HibernateUtil.openHiberanteSession();
		Query query1 = session1.createQuery("from Address");
		query1.setCacheable(true);
		addressList = query1.list();
		for (Address ad1 : addressList) {
			System.out.println("----Address ----" + ad1.getCountry() + "-----"
					+ ad1.getCity());
		}
		HibernateUtil.ClosingHiberanteSession(session1);
		Utils.printMessage(" --------------------------");

	}
	
	
	@After
	public void destory() {

	}

}
