package com.foundation.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foundation.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    List<Customer> findByActiveTrue();
    Page<Customer> findAll(Pageable pageable);
}
