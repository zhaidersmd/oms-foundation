package com.foundation.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.foundation.entity.Customer;



@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer save(Customer customer) {
		if (customer.getId() == null) {
			entityManager.persist(customer);
			return customer;
			
		} else {
			return entityManager.merge(customer);
		}
	}

	@Override
	public List<Customer> findAll() {
		return entityManager
				.createQuery("select c from Customer c", Customer.class)
				.getResultList();
		
	}

	@Override
	public Optional<Customer> findByEmail(String email) {
		List<Customer> result = entityManager
                .createQuery(
                        "SELECT c FROM Customer c WHERE c.email = :email",
                        Customer.class)
                .setParameter("email", email)
                .getResultList();
		return result.stream().findFirst();
	}

	

}
