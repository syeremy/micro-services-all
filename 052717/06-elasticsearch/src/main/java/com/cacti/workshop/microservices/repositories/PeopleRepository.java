package com.cacti.workshop.microservices.repositories;

import com.cacti.workshop.microservices.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by domix on 9/5/16.
 */
public interface PeopleRepository extends ElasticsearchRepository<Person, String> {
  Page<Person> findByNombre(@Param("nombre") String nombre, Pageable page);
}
