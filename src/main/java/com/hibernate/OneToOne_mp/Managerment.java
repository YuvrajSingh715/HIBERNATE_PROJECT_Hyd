package com.hibernate.OneToOne_mp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Managerment {

	public static void main(String[] args) {

		Configuration cnf = new Configuration();

		cnf.configure("com/hibernate/OneToOne_mp/hibernate-config.xml");

		SessionFactory factory = cnf.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		// =========================================================================
		Mail mail1 = new Mail();
		mail1.setMail("haru123@gmail.com");

		Mail mail2 = new Mail();
		mail2.setMail("sai321@gmail.com");

		Mail mail3 = new Mail();
		mail3.setMail("baby789@gmail.com");

		Mail mail4 = new Mail();
		mail4.setMail("geetha147@gmail.com");

		Mail mail5 = new Mail();
		mail5.setMail("navya456@gmail.com");

		Mail mail6 = new Mail();
		mail6.setMail("raj852@gmail.com");
		// ==================================================
		Password pass1 = new Password();
		pass1.setPassword("Navya@18Moon#62");

		Password pass2 = new Password();
		pass2.setPassword("Baby#07Star!84");

		Password pass3 = new Password();
		pass3.setPassword("Sai@25Cloud#91");

		Password pass4 = new Password();
		pass4.setPassword("Raj@21Sun#73");

		Password pass5 = new Password();
		pass5.setPassword("Haru#92Sky!47");

		Password pass6 = new Password();
		pass6.setPassword("Geetha#34Galaxy!58");

		// ===================================================
		mail1.setPassword(pass5);
		mail2.setPassword(pass3);
		mail3.setPassword(pass2);
		mail4.setPassword(pass6);
		mail5.setPassword(pass1);
		mail6.setPassword(pass4);
		
		pass1.setMail(mail5);
		pass2.setMail(mail3);
		pass3.setMail(mail2);
		pass4.setMail(mail6);
		pass5.setMail(mail1);
		pass6.setMail(mail4);

//		session.persist(pass1);
//		session.persist(pass2);
//		session.persist(pass3);
//		session.persist(pass4);
//		session.persist(pass5);
//		session.persist(pass6);
//
//		session.persist(mail1);
//		session.persist(mail2);
//		session.persist(mail3);
//		session.persist(mail4);
//		session.persist(mail5);
//		session.persist(mail6);

		System.out.println("Data Inserted");
		System.out.println("Let's fetch the data");

		Mail m = session.getReference(Mail.class, 3);
		System.out.println("\u001B[33m" + "Mail Id: " + m.getMail());
		System.out.println("\u001B[33m" + "Password: " + m.getPassword().getPassword() + "\u001B[0m");

		transaction.commit();
		session.close();

	}

}
