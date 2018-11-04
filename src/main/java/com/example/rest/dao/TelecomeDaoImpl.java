package com.example.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import org.springframework.stereotype.Repository;
import com.example.rest.dao.IdGenerator;
import com.example.rest.model.domain.Customer;
import com.example.rest.model.view.CustomerCreateModel;

@Repository
public class TelecomeDaoImpl implements TelecomeDao {
	
	private IdGenerator idGenerator;
	
	private ConcurrentHashMap<Long, Customer> customerPhoneNumberMap = new ConcurrentHashMap<>();

	@Inject
	public TelecomeDaoImpl(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	@Override
	public Customer createCustomer(CustomerCreateModel customerDetails) {	
		Long id = idGenerator.getNextId();
		Customer customer = new Customer(id, customerDetails.getName(), customerDetails.getPhoneNumbers());
		customerPhoneNumberMap.put(id, customer);
		return customer;
	}

	@Override
	public Optional<Customer> findCustomerById(Long id) {		
		return customerPhoneNumberMap.entrySet().stream().filter(p -> p.getKey().equals(id)).findAny().map(a -> a.getValue());
	}

	@Override
	public List<Integer> getAllPhoneNumbers() {
		List<Integer> allNumbers = new ArrayList<>();
		customerPhoneNumberMap.values().stream().forEach(p -> allNumbers.addAll(p.getPhoneNumbers()));
		return allNumbers;
	}

}
