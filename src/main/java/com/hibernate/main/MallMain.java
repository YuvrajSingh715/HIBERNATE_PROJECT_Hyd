package com.hibernate.main;

import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Mall;

public class MallMain {

	public static void main(String[] args) {

		Configuration cnf = new Configuration();
		cnf.configure("resource/Mallhibernate-config.xml");

		SessionFactory factory = cnf.buildSessionFactory();
		System.out.println(factory);

		Session session = factory.openSession();

		Mall m = new Mall();
//		m.setMallId(101);   //not need to set the value for id i will automatically generate the id 
		m.setMallName("Next Galleria Mall");
		m.setNumberOfFloors(7);
		m.setNumberOfShops(67);
		m.setOpeningTime(LocalTime.of(9, 0));
		m.setClosingTime(LocalTime.of(10, 0));

		Transaction transaction = session.beginTransaction();
//		Mall m1 = session.get(Mall.class, 1);
//		System.out.println(m1);

		session.persist(m);
		transaction.commit();
		session.close();

	}

}
