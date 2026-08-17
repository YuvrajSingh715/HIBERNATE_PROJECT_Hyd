package com.hibernate.updatemallvalue;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.boilercode.DBConnectionProvider;
import com.hibernate.entity.Mall;

public class UpdateValue {

	public static void main(String[] args) {

		Session session = DBConnectionProvider.getConnection().openSession();

		Transaction transaction = session.beginTransaction();

		Mall mall = session.getReference(Mall.class, 602);

		System.out.println("Before Updating: " + mall);

//		updating mallname from satyam mall -> yuvraj mall
		mall.setMallName("Yuvraj Mall");

		System.out.println("After Updating: " + mall);

		transaction.commit();

		session.close();
	}

}
