package com.hibernate.classpractice_d6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpMain {

	public static void main(String[] args) {

		Configuration cnf = new Configuration();

		cnf.configure("com/hibernate/classpractice_d6/hibernate-cnf.xml");

		SessionFactory factory = cnf.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		EmployeeAddress ea = new EmployeeAddress();
		ea.setStreet("Shiv Bagh colony");
		ea.setLocation("SR Nagar");

		CompanyAddress ca = new CompanyAddress();
		ca.setName("MicroSoft");
		ca.setStreet("B-56, MG Road");
		ca.setLocation("Hytech city");

		Employee1 e = new Employee1();
		e.setEmpName("Raj");
		e.setEmpAddress(ea);
		e.setCmpAddress(ca);

//		session.persist(e);
		System.out.println("data inserted");

		Employee1 e1 = session.getReference(Employee1.class, 1);
		System.out.println(e1);

		transaction.commit();
		session.close();

	}

}
