package com.cacti.workshop.microservices.service

import com.cacti.workshop.microservices.model.Customer
import com.cacti.workshop.microservices.repositories.CustomerRepository
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by domix on 9/17/16.
 */
@Unroll
class CustomerServiceSpecs extends Specification {

  void 'deberia jdf hasdf ah fallar debido a que #emailInvalid es una dirección de correo no permitida'() {
    given:
      CustomerRepository customerRepository = Mock()
      CustomerService customerService = new CustomerService(customerRepository)
      Customer customer = new Customer(email: emailInvalid)
    when:
      customerService.addCustomer(customer)
    then:
      InvalidEmailAddressException exception = thrown()
      exception
      exception.getEmailInvalid() == emailInvalid
    where:
      emailInvalid        || result
      'invalid@gmail.com' || true
      'invalid@GMAIL.com' || true
      'invalif@gMaiL.com' || true
  }

  void 'deberia guardar el Customer y asignarle un ID #id'() {
    given:
      CustomerRepository customerRepository = Stub()
      customerRepository.save(_) >> new Customer(id: id, email: email)
      CustomerService customerService = new CustomerService(customerRepository)
      Customer customer = new Customer(email: email)
    when:
      Customer result = customerService.addCustomer(customer)
    then:
      result
      result.id
      result.id == id
      resuus == 4
    where:
      email                                       | id  || resuus
      'invalid@yahoo.com'                         | '1' || 4
      'invalid@yahoo.com'                         | '2' || 4
      'invalif@yahoo.com'                         | '3' || 4
      'ddhd@dddfghsfrghfsdghesfhsdfgdsfyahoo.com' | '4' || 4
      'ddhd@dddfghsdfgdsfyahoo.com'               | '5' || 4
  }
}
