package com.example.rest.model.view;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerViewModel {
	
    private Long id;
	
	private String name;
	
	private List<Integer> phoneNumbers = new ArrayList<>();

	public CustomerViewModel(Long id, String name, List<Integer> phoneNumbers) {
		this.id = id;
		this.name = name;
		this.phoneNumbers = phoneNumbers;
	}

	@JsonProperty("customerId")
	public Long getId() {
		return id;
	}

	@JsonProperty("customerName")
	public String getName() {
		return name;
	}

	@JsonProperty("phoneNumbers")
	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}


	
}
