package com.example.rest.dao;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.example.rest.dao.IdGenerator;
import com.example.rest.dao.TelecomeDaoImpl;
import com.example.rest.model.domain.Customer;
import com.example.rest.model.view.CustomerCreateModel;

public class TelecomeDAOIntegrationTest {
	
	private IdGenerator idGenerator;
	
	private TelecomeDaoImpl telecomeDaoImpl;
	
	private CustomerCreateModel customerDetails;
	
    private List<Integer> phoneNumbers = new ArrayList<>();
    
    private Long invalid_id = 1234L;
	
	@Before
	public void setUp() {
		idGenerator = new IdGenerator();
		telecomeDaoImpl = new TelecomeDaoImpl(idGenerator);	
		phoneNumbers.add(1265765276);
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = createCustomer();
		assertNotNull(customer);
		assertEquals(customer.getName(), customerDetails.getName());
	}
	
	@Test	
	public void testGetAllPhoneNumbersWhenTwoCustomersInjected() {
		createCustomer();
		createCustomer();
		List<Integer> allPhoneNumbers = telecomeDaoImpl.getAllPhoneNumbers();
		assertEquals(2, allPhoneNumbers.size());
	}
	
	
	@Test
	public void testFindPhoneNumberByValidId() {
		createCustomer();
		assertTrue(telecomeDaoImpl.findCustomerById(1L).isPresent());
	}
	
	@Test
	public void testFindPhoneNumberByInvalidId() {
		createCustomer();
		assertFalse(telecomeDaoImpl.findCustomerById(invalid_id).isPresent());
	}
	
	public Customer createCustomer() {
		customerDetails = new CustomerCreateModel();
		customerDetails.setName("");
		customerDetails.setPhoneNumbers(phoneNumbers);
		return telecomeDaoImpl.createCustomer(customerDetails);
	}

}
