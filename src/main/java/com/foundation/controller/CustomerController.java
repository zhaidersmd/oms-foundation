package com.foundation.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foundation.dto.CustomerRequestDto;
import com.foundation.entity.Customer;
import com.foundation.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> create(
            @Valid @RequestBody CustomerRequestDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<Customer> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/paged")
    public Page<Customer> getPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return service.getCustomers(page, size);
    }
    
    @GetMapping("/by-email")
    public Customer getByEmail(@RequestParam String email) {
        return service.getByEmail(email);
    }
}