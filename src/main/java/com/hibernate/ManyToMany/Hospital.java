package com.hibernate.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hospital {

	public static void main(String[] args) {

		Configuration cnf = new Configuration();
		cnf.configure("com/hibernate/ManyToMany/hibernate-config.xml");
		SessionFactory factory = cnf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// Setting the doctors name
		Doctor doc1 = new Doctor();
		doc1.setName("Dr. Sophia Brown");
		Doctor doc2 = new Doctor();
		doc2.setName("Dr. Daniel Miller");

		// Setting the patients name
		Patient pat1 = new Patient();
		pat1.setName("Noah");
		Patient pat2 = new Patient();
		pat2.setName("Dean");
		Patient pat3 = new Patient();
		pat3.setName("Allie");

		// ======================================
		List<Doctor> sameDoctor = new ArrayList<>();
		sameDoctor.add(doc1);
		sameDoctor.add(doc2);

		List<Doctor> diffDoctor = new ArrayList<Doctor>();
		diffDoctor.add(doc2);

		List<Doctor> diffDoctor1 = new ArrayList<Doctor>();
		diffDoctor1.add(doc1);

		List<Patient> samePatient = new ArrayList<>();
		samePatient.add(pat1);
		samePatient.add(pat2);
		samePatient.add(pat3);

		List<Patient> diffPatient = new ArrayList<Patient>();
		diffPatient.add(pat3);

		// =======================================
		pat1.setDoctor(sameDoctor);
		pat2.setDoctor(diffDoctor);
		pat3.setDoctor(diffDoctor1);

		doc1.setPatient(samePatient);
		doc2.setPatient(diffPatient);

		session.persist(doc1);
		session.persist(doc2);

		System.out.println("Data inserted successfully");
		System.out.println("Fetching the date for DB");

		Doctor d = session.getReference(Doctor.class, 1);
		System.out.println("\u001B[33m" + "Doctor Name: " + d.getName());
		List<Patient> data = d.getPatient();
		data.stream().forEach(System.out::println);
		System.out.println("\u001B[0m");
		
//		Doctor d1 = session.getReference(Doctor.class, 2);
//		System.out.println("\u001B[32m" + "Doctor Name: " + d1.getName());
//		List<Patient> data1 = d1.getPatient();
//		data1.stream().forEach(System.out::println);
//		System.out.println("\u001B[0m");
		
//		Patient p1 = session.getReference(Patient.class, 1);
//		System.out.println("\u001B[36m" + "Patient Name: " + p1.getName());
//		List<Doctor> input1 = p1.getDoctor();
//		input1.stream().forEach(System.out::println);
//		System.out.println("\u001B[0m");
		
//		Patient p2 = session.getReference(Patient.class, 2);
//		System.out.println("\u001B[35m" + "Patient Name: " + p2.getName());
//		List<Doctor> input2 = p2.getDoctor();
//		input2.stream().forEach(System.out::println);
//		System.out.println("\u001B[0m");
		
//		Patient p3 = session.getReference(Patient.class, 3);
//		System.out.println("\u001B[36m" + "Patient Name: " + p3.getName());
//		List<Doctor> input3 = p3.getDoctor();
//		input3.stream().forEach(System.out::println);
//		System.out.print("\u001B[0m");

		transaction.commit();
		session.close();

	}

}
