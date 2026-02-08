package com.foundation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foundation.dao.CustomerDao;
import com.foundation.dto.CustomerRequestDto;
import com.foundation.entity.Customer;
import com.foundation.mapper.CustomerMapper;

@Service
public class CustomerService {
	private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer create(CustomerRequestDto dto) {
        Customer customer = CustomerMapper.toEntity(dto);
        return customerDao.save(customer);
    }

    public List<Customer> getAll() {
        return customerDao.findAll();
    }

}
