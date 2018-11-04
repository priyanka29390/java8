package com.example.rest.model.domain;

import java.util.List;

public class Customer {
	
	private Long id;
	
	private String name;
	
	private List<Integer> phoneNumbers;
	
	public Customer(Long id, String name, List<Integer> phoneNumbers) {
		this.id = id;
		this.name = name;
		this.phoneNumbers = phoneNumbers;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}

	

}
