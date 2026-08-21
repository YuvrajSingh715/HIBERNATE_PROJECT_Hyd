package com.hibernate.OneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "book")
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int id;
	
	private String book;
	
	@ManyToOne()
	@ToString.Exclude
	@JoinColumn(name = "Foreign_key_Library")
	private Library library;
	
}
