package com.hibernate.getmallvalue;

import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.boilercode.DBConnectionProvider;
import com.hibernate.entity.Mall;

public class NewWay {

	public static void main(String[] args) {

		Session session = DBConnectionProvider.getConnection().openSession();

		Transaction transaction = session.beginTransaction();

		Mall mall = session.getReference(Mall.class, 1);

//		System.out.println("Mall ID: " + mall.getMallId());
//		System.out.println("Mall Name: " + mall.getMallName());
//		System.out.println("Mall Floors: " + mall.getNumberOfFloors());
//		System.out.println("Mall Shops: " + mall.getNumberOfShops());
//		System.out.println("Mall Opening time: " + mall.getOpeningTime());
//		System.out.println("Mall Closing time: " + mall.getClosingTime());

		// getReference is the updated version of load() method;

		// 1. if we are using the getReference() select query will not always run by
		//    default
		// 2. Even if we are not calling the get.variables() also it will not execute
		// 3. if we calling the not existing id we will get ObjectNotFoundException with
		//    select query execute
		// 4. but if we calling not existing id and didn't give the SOP then we will not
		//    get exception and select query
	}

}
