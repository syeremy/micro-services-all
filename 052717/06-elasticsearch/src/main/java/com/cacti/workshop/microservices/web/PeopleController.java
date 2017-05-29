package com.cacti.workshop.microservices.web;

import com.cacti.workshop.microservices.domain.Person;
import com.cacti.workshop.microservices.repositories.PeopleRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Created by domix on 9/5/16.
 */
@RequestMapping("/people")
@RestController
public class PeopleController {
  private final PeopleRepository peopleRepository;

  public PeopleController(PeopleRepository peopleRepository) {
    this.peopleRepository = peopleRepository;
  }

  @PostMapping
  public HttpEntity index(@RequestBody Person person) {
    return ok(peopleRepository.index(person));
  }

  @GetMapping
  public HttpEntity get(@RequestParam("nombre") String nombre, Pageable page) {
    return ok(peopleRepository.findByNombre(nombre, page).getContent());
  }
}
