package com.hibernate.getmallvalue;

import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.boilercode.DBConnectionProvider;
import com.hibernate.entity.Mall;
import com.hibernate.entity.MallStaff;

public class StaffReference {

	public static void main(String[] args) {

		Session session = DBConnectionProvider.getConnection().openSession();
		Transaction transaction = session.beginTransaction();

		MallStaff ms = new MallStaff();
		ms.setStaffName("John");
		ms.setGender("male");
		ms.setSalary(34500.9);

		Mall m = new Mall();
		m.setClosingTime(LocalTime.of(22, 45));
		m.setMallName("Raj Mall");
		m.setNumberOfFloors(8);
		m.setNumberOfShops(64);
		m.setOpeningTime(LocalTime.of(9, 45));
		m.setMallStaff(ms);

//		session.persist(m);
		System.out.println("Data Added!!");
		System.out.println("Data Fetching from db");

		Mall mall = session.getReference(Mall.class, 1102);
		System.out.println(mall);
		transaction.commit();
		session.close();
	}

}
