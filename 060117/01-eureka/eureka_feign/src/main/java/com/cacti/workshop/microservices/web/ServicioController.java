package com.cacti.workshop.microservices.web;

import com.cacti.workshop.microservices.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ServicioController {
  private final Client client;

  @Autowired
  public ServicioController(Client client) {
    this.client = client;
  }

  @GetMapping
  public HttpEntity data(@RequestParam(name = "fail", required = false, defaultValue = "false") Boolean fail) throws Exception {
    return ResponseEntity.ok(client.saluda(fail));
  }
}
