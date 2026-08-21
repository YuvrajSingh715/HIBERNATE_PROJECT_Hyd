package com.hibernate.OneToMany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {

		Configuration cnf = new Configuration();
		cnf.configure("com/hibernate/OneToMany/hibernate-config.xml");

		SessionFactory factory = cnf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Library lib = new Library();
		lib.setLibrary("Night Hunter Library");

		Book book1 = new Book();
		book1.setBook("The Hidden Island");
		book1.setLibrary(lib);

		Book book2 = new Book();
		book2.setBook("Treasure of the Lost Sea");
		book2.setLibrary(lib);

		Book book3 = new Book();
		book3.setBook("The Forbidden Forest");
		book3.setLibrary(lib);

		Book book4 = new Book();
		book4.setBook("The Mysterious Cave");
		book4.setLibrary(lib);

		lib.setBook(Arrays.asList(book1, book2, book3, book4));
		List<Book> data = new ArrayList<>();
		data.add(book1);
		data.add(book2);
		data.add(book3);
		data.add(book4);
		lib.setBook(data);

		session.persist(lib);
		session.persist(book1);
		session.persist(book2);
		session.persist(book3);
		session.persist(book4);

		System.out.println("Data Inserted Successfully");
		System.out.println("Let's fetch the data for DB");

		Library l = session.getReference(Library.class, 1);
		System.out.println("\u001B[33m" + "Library: "+l.getLibrary());
		List<Book> input = l.getBook();
		input.forEach(System.out::println);
		System.out.print("\u001B[0m");
		
		
		transaction.commit();
		session.close();

	}

}
