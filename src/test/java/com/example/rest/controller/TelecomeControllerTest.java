package com.example.rest.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.rest.model.domain.Customer;
import com.example.rest.model.view.CustomerCreateModel;
import com.example.rest.model.view.CustomerViewModel;
import com.example.rest.service.TelecomeService;

@RunWith(MockitoJUnitRunner.class)
public class TelecomeControllerTest {

	@Mock
    private TelecomeService telecomeService;
	
	@Mock
	private CustomerViewModelConverter viewModelConvertor;
	
	@InjectMocks
	private TelecomeController controller;
	
	private CustomerCreateModel customerCreateModel;
	
	private Customer customer;
	
	private CustomerViewModel customerViewModel;
	
	private List<Integer> phoneNumbers = new ArrayList<>();
	
	private Long id = 1L;
	
	@Before
	public void setUp() {
		phoneNumbers.add(1265765276);
	}
	
	@Test
	public void testCreateCustomer() {
		givenAcustomerCreateModel();
		givenACustomerObject();
		givenAnExpectedCustomerViewModel();
		whenIcallConverter();
		when(telecomeService.createCustomer(customerCreateModel)).thenReturn(customer);
		ResponseEntity<CustomerViewModel> response = controller.createCustomer(customerCreateModel);	
		assertThat(response.getBody(), is(customerViewModel));
		assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
	}

	private void givenAnExpectedCustomerViewModel() {
		customerViewModel = new CustomerViewModel(1L , "Priyanka", phoneNumbers);	
	}

	private void givenACustomerObject() {
	    customer = new Customer(1L, "Priyanka", phoneNumbers);		
	}

	private void givenAcustomerCreateModel() {
		customerCreateModel = new CustomerCreateModel();
		customerCreateModel.setName("Priyanka");
		customerCreateModel.setPhoneNumbers(phoneNumbers);
	}
	
	@Test
	public void testfindPhoneNumbersByCustomerIdWhenSucessful() {
		givenACustomerObject();
		givenAnExpectedCustomerViewModel();
		whenIcallConverter();
		when(telecomeService.findCustomerById(id)).thenReturn(Optional.of(customer));
		ResponseEntity<List<Integer>> responseEntity= controller.findPhoneNumbersByCustomerId(id);
		assertThat(responseEntity.getStatusCode(),is(HttpStatus.OK));	
	}
	
	@Test
	public void testfindPhoneNumbersByCustomerIdUnsuccessful() {
		givenACustomerObject();
		givenAnExpectedCustomerViewModel();
		whenIcallConverter();
		when(telecomeService.findCustomerById(id)).thenReturn(Optional.empty());
		ResponseEntity<List<Integer>> responseEntity= controller.findPhoneNumbersByCustomerId(id);
		assertThat(responseEntity.getStatusCode(),is(HttpStatus.NOT_FOUND));		
	}
	
	@Test
	public void testGetAllPhoneNumbers() {
		controller.getAllPhoneNumbers();
		verify(telecomeService).getAllPhoneNumbers();
	}
	
	public void whenIcallConverter(){
		when(viewModelConvertor.convert(customer)).thenReturn(customerViewModel);
	}
	
	

}
