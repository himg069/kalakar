package com.gpg.swarna.kalakar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpg.swarna.kalakar.entity.Customer;
import com.gpg.swarna.kalakar.payload.CustomerDto;
import com.gpg.swarna.kalakar.service.CustomerService;

@RestController
@RequestMapping("/customer/details")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//POST
	@PostMapping("/")
	public ResponseEntity<CustomerDto> createUser(@RequestBody CustomerDto customerDto){
		CustomerDto addNewCustomer = this.customerService.addNewCustomer(customerDto);
		
		return new ResponseEntity<>(addNewCustomer, HttpStatus.CREATED);
		
	}
	
	//PUT
	@PutMapping("/{customerName}")
	public ResponseEntity<CustomerDto> updateCustomerDetails(@RequestBody CustomerDto customerDto, @PathVariable("customerName") String customerName){
		CustomerDto addNewCustomer = this.customerService.updateCustomerDetails(customerDto, customerName);
		
		return new ResponseEntity<>(addNewCustomer, HttpStatus.OK);
		
	}
	
	//DELETE
	
	//GET
	@GetMapping("/{customerName}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable("customerName") String customerName){
		Customer getCustomer = this.customerService.getCustomerDeatilsByName(customerName);
		
		return new ResponseEntity<Customer>(getCustomer, HttpStatus.OK);
		
	}
	

}
