package com.foundation.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import com.foundation.entity.Customer;


@Repository
public class CustomerDAO {
	private final EntityManager entityManager;

    public CustomerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Customer customer) {
        entityManager.persist(customer);
    }
}
