package com.hibernate.boilercode;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnectionProvider {

	private static SessionFactory factory = null;

	private DBConnectionProvider() {
	}

	public static SessionFactory getConnection() {
		if (factory == null) {
			Configuration cnf = new Configuration();
			cnf.configure("resource/Mallhibernate-config.xml");

			factory = cnf.buildSessionFactory();
			System.out.println(factory);
		}

		return factory;
	}

}
