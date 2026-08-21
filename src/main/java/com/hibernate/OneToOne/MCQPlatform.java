package com.hibernate.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MCQPlatform {

	public static void main(String[] args) {

		Configuration cnf = new Configuration();

		cnf.configure("com/hibernate/OneToOne/hibernate-config.xml");

		SessionFactory factory = cnf.buildSessionFactory();

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		// ===============================================================

		Questions que1 = new Questions();
		que1.setQuestion("What is openSession() method ?");

		Questions que2 = new Questions();
		que2.setQuestion("How to change the column name in DB ?");

		Questions que3 = new Questions();
		que3.setQuestion("Through which Annotation we can hide the column in DB ?");

		Answers ans1 = new Answers();
		ans1.setAnswer("By using the @Transient Annotation.");

		Answers ans2 = new Answers();
		ans2.setAnswer("By OpenSession() we can perform the bulk of operations.");

		Answers ans3 = new Answers();
		ans3.setAnswer("By using the @Column Annotation.");

		// ===============================================================

		que1.setAnswer(ans2);
		que2.setAnswer(ans3);
		que3.setAnswer(ans1);

//		session.persist(que1);
//		session.persist(que2);
//		session.persist(que3);
//
//		session.persist(ans1);
//		session.persist(ans2);
//		session.persist(ans3);

		System.out.println("Data Inserted");
		System.out.println("Fetch the data from DB");

		Questions q = session.getReference(Questions.class, 3);
		System.out.println("\u001B[33m" + "Que: " + q.getQuestion());
		System.out.println("\u001B[33m" + "Ans: " + q.getAnswer().getAnswer() + "\u001B[0m");

		transaction.commit();
		session.close();

	}

}
