package com.deloitte.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

//			List<Employee> employees = session.createQuery("from Employee").getResultList();
			Employee myemployee = new Employee("Soni",86.5);
			session.beginTransaction();
			session.save(myemployee);
			session.getTransaction().commit();
			System.out.println("Done");
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}
	}
}

