package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by domix on 8/27/16.
 */
@RestController
public class MyController {
  @Autowired
  Service service;

  @RequestMapping("/{name}")
  public String foo(@PathVariable("name") String name) {
    return service.saludo(name);
  }
}
