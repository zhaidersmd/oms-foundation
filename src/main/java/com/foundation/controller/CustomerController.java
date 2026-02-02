package com.foundation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foundation.entity.Customer;
import com.foundation.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public List<Customer> getAll(){
		return customerService.getAll();
	}
	
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer customer) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(customerService.create(customer));
		
	}
}
