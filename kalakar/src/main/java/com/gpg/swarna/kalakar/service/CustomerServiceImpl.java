package com.gpg.swarna.kalakar.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpg.swarna.kalakar.entity.Customer;
import com.gpg.swarna.kalakar.exception.ResourceNotFoundException;
import com.gpg.swarna.kalakar.payload.CustomerDto;
import com.gpg.swarna.kalakar.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CustomerDto addNewCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub

		Customer dtoToCustomer = this.dtoToCustomer(customerDto);
		if (dtoToCustomer.getRateOfInterest() == null) {
			if (dtoToCustomer.getAmountLend() >= 20000)
				dtoToCustomer.setRateOfInterest(5.0);
			else if (dtoToCustomer.getAmountLend() >= 50000)
				dtoToCustomer.setRateOfInterest(2.5);
			else if (dtoToCustomer.getAmountLend() >= 100000)
				dtoToCustomer.setRateOfInterest(1.0);
			else
				dtoToCustomer.setRateOfInterest(3.0);
		}
		Customer savedCustomer = this.customerRepo.save(dtoToCustomer);
		return this.CustomerToDto(savedCustomer);
	}

	@Override
	public CustomerDto updateCustomerDetails(CustomerDto customerDto, String customerName) {
		// TODO Auto-generated method stub
		Optional<Customer> findByCustomerName = this.customerRepo.findByCustomerName(customerName);
		findByCustomerName.get().setCustomerName(customerDto.getCustomerName());
		findByCustomerName.get().setCustVillageName(customerDto.getCustVillageName());
		Customer updatedCustomer = this.customerRepo.save(findByCustomerName.get());
		return this.CustomerToDto(updatedCustomer);
	}

	@Override
	public Customer getCustomerDeatilsByName(String customerName) {
		// TODO Auto-generated method stub
		Optional<Customer> findByCustomerName = Optional.of(this.customerRepo.findByCustomerName(customerName)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerName)));
//		List<Customer> collect = findByCustomerName.stream().collect(Collectors.toList());
		return findByCustomerName.get();
	}

	@Override
	public Customer getCustomerDeatilsById(Integer customerId) {
		// TODO Auto-generated method stub
		Customer customer = this.customerRepo.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
		return customer;
	}

	@Override
	public List<CustomerDto> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> findAllCustomers = this.customerRepo.findAll();
		return findAllCustomers.stream().map(customer -> this.CustomerToDto(customer)).collect(Collectors.toList());
	}

	@Override
	public String deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Customer searchedCustomer = this.customerRepo.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
		String returnValue = "Successfully Deleted Customer:" + searchedCustomer.getCustomerName();
		this.customerRepo.delete(searchedCustomer);
		return returnValue;
	}

	// creating alternative of mapper\\\

	private Customer dtoToCustomer(CustomerDto customerDto) {
//		Customer customer = new Customer();
		Customer customer = this.mapper.map(customerDto, Customer.class);
//		customer.setCustomerId(customerDto.getCustomerId());
//		customer.setCustomerName(customerDto.getCustomerName());
//		customer.setCustVillageName(customerDto.getCustVillageName());
//		customer.setAmountLend(customerDto.getAmountLend());
//		customer.setItemDetails(customerDto.getItemDetails());
//		customer.setReferenceName(customerDto.getCustomerName());
		return customer;
	}

	private CustomerDto CustomerToDto(Customer customer) {
//		CustomerDto customerDto = new CustomerDto();
		CustomerDto customerDto = this.mapper.map(customer, CustomerDto.class);
//		customerDto.setCustomerId(customer.getCustomerId());
//		customerDto.setCustomerName(customer.getCustomerName());
//		customerDto.setCustVillageName(customer.getCustVillageName());
//		customerDto.setAmountLend(customer.getAmountLend());
//		customerDto.setItemDetails(customer.getItemDetails());
//		customerDto.setReferenceName(customer.getReferenceName());
		return customerDto;
	}

}
