package com.foundation.dao;

import java.util.List;
import java.util.Optional;

import com.foundation.entity.Customer;

public interface CustomerDao {
	
	Customer save(Customer customer);
	List<Customer> findAll();
	Optional<Customer> findByEmail(String email);

}
