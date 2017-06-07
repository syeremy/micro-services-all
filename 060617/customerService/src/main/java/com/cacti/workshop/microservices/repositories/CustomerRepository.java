package com.cacti.workshop.microservices.repositories;

import com.cacti.workshop.microservices.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by domix on 9/12/16.
 */
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
