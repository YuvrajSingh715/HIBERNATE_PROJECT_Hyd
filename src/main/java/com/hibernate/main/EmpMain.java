package com.hibernate.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

public class EmpMain {

	public static void main(String[] args) throws IOException {

		Configuration con = new Configuration();

		con.configure("resource/Emphibernate-config.xml");

		SessionFactory sf = con.buildSessionFactory();

		System.out.println(sf);

		Employee emp = new Employee();
//		emp.setId(102);  //auto generation is on
		emp.setName("Yuvraj");
		emp.setFullAddress("Shiv_bagh, Ameerpet");
		emp.setSalary(33240.05);
		emp.setCompanyName("HCL");
		emp.setHrMail("hr321@Gmail.com");

		// LocalDate
		emp.setJoiningDate(LocalDate.of(2024, 10, 21));

		// LocalTime
		emp.setProjectSubmissionTime(LocalTime.of(6, 10));

		// LocalDateTime
		emp.setProjectAssignmentZone(LocalDateTime.of(2025, 03, 07, 3, 10));

		// Reading the image for laptop
		Path path = Paths.get("C:\\Users\\pc\\Documents\\hibernate\\nature.jpeg");
		byte[] imageByte = Files.readAllBytes(path);

		// Setting image into Employee Object
//		emp.setProjectImage(imageByte);

		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(emp);

		Employee e = session.get(Employee.class, 1);
		System.out.println(e);

		// Get Image back from Employee Object
		byte[] employeeImage = emp.getProjectImage();

		// Destination path where you want to save the image
//		Path path1 = Paths.get("C:\\Users\\pc\\Documents\\hibernate\\ReturnBacknature.jpeg");
		
		// write Image to laptop
//		Files.write(path1, employeeImage);

		transaction.commit();

		session.close();

	}

}