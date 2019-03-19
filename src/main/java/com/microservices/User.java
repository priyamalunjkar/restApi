package com.microservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Id
	private int id;
	private String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
