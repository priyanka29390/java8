package com.example.rest.service;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.example.rest.dao.TelecomeDao;
import com.example.rest.model.domain.Customer;
import com.example.rest.model.view.CustomerCreateModel;

@Service
public class TelecomeService {
	
	private TelecomeDao telecomeDao;
	
	@Inject
	public TelecomeService(TelecomeDao telecomeDao) {
		this.telecomeDao = telecomeDao;
	}

	public Customer createCustomer(CustomerCreateModel customer) {
		return telecomeDao.createCustomer(customer);
	}

	public Optional<Customer> findCustomerById(Long id) {
		return telecomeDao.findCustomerById(id);
	}

	public List<Integer> getAllPhoneNumbers() {
		return telecomeDao.getAllPhoneNumbers();
	}
	
	

}
