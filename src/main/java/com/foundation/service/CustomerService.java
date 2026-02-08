package com.foundation.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    public Page<Customer> getCustomers(int page, int size) {
    	Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
    	return customerDao.findAll(pageable);
    }
    
    @Transactional(readOnly = true)
    public Customer getByEmail(String email) {
        return customerDao.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found"));
    }

    
   

}
