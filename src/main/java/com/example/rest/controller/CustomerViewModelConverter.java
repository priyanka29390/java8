package com.example.rest.controller;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.rest.model.domain.Customer;
import com.example.rest.model.view.CustomerViewModel;

@Component
public class CustomerViewModelConverter implements Converter<Customer, CustomerViewModel> {

	@Override
	public CustomerViewModel convert(Customer source) {
		CustomerViewModel customerViewModel = new CustomerViewModel(source.getId(), source.getName(), source.getPhoneNumbers());
		return customerViewModel;
	}
	
	

	
	
}
