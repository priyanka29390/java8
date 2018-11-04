package com.example.rest.model.view;

import java.util.ArrayList;
import java.util.List;

public class CustomerCreateModel {
		
	private String name;
		
	private List<Integer> phoneNumbers = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
}
