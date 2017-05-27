package com.cacti.workshop.microservices.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by domix on 5/27/17.
 */
public interface PersonRepository extends JpaRepository<Person, String> {
}
