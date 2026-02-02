package com.foundation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foundation.dao.CustomerDao;
import com.foundation.entity.Customer;

@Service
public class CustomerService {
	
	
	private final CustomerDao customerDao;
	
	public CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public Customer create(Customer customer) {
		return customerDao.save(customer);
	}
	
	public List<Customer> getAll() {
		return customerDao.findAll();
	}
	
	

}
