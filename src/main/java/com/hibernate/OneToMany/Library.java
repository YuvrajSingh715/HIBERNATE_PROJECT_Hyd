package com.hibernate.OneToMany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "library")
@Data
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "library_id")
	private int id;
	
	private String library;
	
	@OneToMany(mappedBy = "library")
	@ToString.Exclude
	private List<Book> book;
}
