package com.example.rest.dao;

import java.util.List;
import java.util.Optional;

import com.example.rest.model.domain.Customer;
import com.example.rest.model.view.CustomerCreateModel;

public interface TelecomeDao {

	Customer createCustomer(CustomerCreateModel customer);

	Optional<Customer> findCustomerById(Long id);

	List<Integer> getAllPhoneNumbers();

}
