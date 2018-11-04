package com.example.rest.controller;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.rest.model.domain.Customer;
import com.example.rest.model.view.CustomerCreateModel;
import com.example.rest.model.view.CustomerViewModel;
import com.example.rest.service.TelecomeService;

@Controller
@RequestMapping(value = "/telecome", produces = MediaType.APPLICATION_JSON_VALUE)
public class TelecomeController {
	
	private TelecomeService telecomeService;
	
	private CustomerViewModelConverter viewModelConvertor;
			
    @Inject
	public TelecomeController(TelecomeService telecomeService, CustomerViewModelConverter viewModelConvertor) {
		this.telecomeService = telecomeService;
		this.viewModelConvertor = viewModelConvertor;
	}

    @RequestMapping(method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ResponseEntity<CustomerViewModel> createCustomer(@RequestBody CustomerCreateModel customerDetails) {
		Customer customer = telecomeService.createCustomer(customerDetails);		
		return new ResponseEntity<>(viewModelConvertor.convert(customer) , HttpStatus.CREATED);	
	}
      
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
	public ResponseEntity<List<Integer>> findPhoneNumbersByCustomerId(@PathVariable("id")Long id){
	   Optional<Customer> customer = telecomeService.findCustomerById(id);
  	   if(customer.isPresent()) {
  		   List<Integer> list = customer.get().getPhoneNumbers();
  		   return new ResponseEntity<>(list, HttpStatus.OK);
 	    }else {
 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 		}
	}
       
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
	public List<Integer> getAllPhoneNumbers(){
    	return telecomeService.getAllPhoneNumbers();
	}	
	
}
