package com.gpg.swarna.kalakar.service;

import java.util.List;

import com.gpg.swarna.kalakar.entity.Customer;
import com.gpg.swarna.kalakar.payload.CustomerDto;

public interface CustomerService {
	
	CustomerDto addNewCustomer(CustomerDto customerService);
//	CustomerDto updateCustomerDetails(CustomerDto customerDto);
	Customer getCustomerDeatilsByName(String customerName);
	Customer getCustomerDeatilsById(Integer customerId);
	List<CustomerDto> getAllCustomer();
//	String deleteCustomer(String customerId);
	CustomerDto updateCustomerDetails(CustomerDto customerDto, String customerName);
	String deleteCustomer(Integer customerId);

}
