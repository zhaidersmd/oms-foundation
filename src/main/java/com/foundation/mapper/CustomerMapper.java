package com.foundation.mapper;

import com.foundation.dto.CustomerRequestDto;
import com.foundation.entity.Customer;

public class CustomerMapper {

    public static Customer toEntity(CustomerRequestDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        return customer;
    }
}
