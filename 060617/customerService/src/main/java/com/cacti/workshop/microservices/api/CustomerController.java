package com.cacti.workshop.microservices.api;

import com.cacti.workshop.microservices.model.Customer;
import com.cacti.workshop.microservices.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by domix on 9/12/16.
 */
@RestController
@Slf4j
@RequestMapping("/v1/customer")
public class CustomerController {

  private final CustomerRepository customerRepository;
  private final String instanceId;

  public CustomerController(CustomerRepository customerRepository,
                            @Value("${instance.id}") String instanceId) {
    this.customerRepository = customerRepository;
    this.instanceId = instanceId;
  }

  @PostMapping
  public HttpEntity addCustomer(@RequestBody Customer customer) {
    log.info("Procesando petición en el nodo {}", instanceId);
    return ResponseEntity.ok(customerRepository.save(customer));
  }
}
