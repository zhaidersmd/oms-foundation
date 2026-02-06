package com.foundation.repository;

import org.springframework.stereotype.Repository;
import com.foundation.entity.Customer;
import jakarta.persistence.EntityManager;

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
