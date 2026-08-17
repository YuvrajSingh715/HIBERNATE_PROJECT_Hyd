package com.hibernate.removemallvalue;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.boilercode.DBConnectionProvider;
import com.hibernate.entity.Mall;

public class RemoveValue {

	public static void main(String[] args) {

		Session session = DBConnectionProvider.getConnection().openSession();

		Transaction transaction = session.beginTransaction();

		Mall mall = session.getReference(Mall.class, 802);

		session.remove(mall);

		System.out.println("Data Deleted");

		transaction.commit();

		session.close();

	}

}
