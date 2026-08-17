package com.hibernate.getmallvalue;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.boilercode.DBConnectionProvider;
import com.hibernate.entity.Mall;

public class OldWay {

	public static void main(String[] args) {

		Session session = DBConnectionProvider.getConnection().openSession();

		Transaction transaction = session.beginTransaction();

		Mall mall = session.get(Mall.class, 1);

//		System.out.println("Mall ID: " + mall.getMallId());
//		System.out.println("Mall Name: " + mall.getMallName());
//		System.out.println("Mall Floors: " + mall.getNumberOfFloors());
//		System.out.println("Mall Shops: " + mall.getNumberOfShops());
//		System.out.println("Mall Opening time: " + mall.getOpeningTime());
//		System.out.println("Mall Closing time: " + mall.getClosingTime());

		// 1. if we are using the get() select query will always run by default
		// 2. even if we are not call the get.variables() it will execute
		// 3. if we calling the not existing id we will get NullPointerException but still
		//    select query execute
		// 4. but if we calling not existing id and didn't give the SOP then we will not
		//    get exception
	}

}
