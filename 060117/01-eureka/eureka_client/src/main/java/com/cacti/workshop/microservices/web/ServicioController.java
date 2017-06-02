package com.cacti.workshop.microservices.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/serviceDummy")
public class ServicioController {
  private final DiscoveryClient discoveryClient;
  private final ObjectMapper objectMapper;

  @Autowired
  public ServicioController(DiscoveryClient discoveryClient, ObjectMapper objectMapper) {
    this.discoveryClient = discoveryClient;
    this.objectMapper = objectMapper;
  }

  @RequestMapping(method = GET)
  public HttpEntity data() throws Exception {
    List<ServiceInstance> data = discoveryClient.getInstances("data");

    return ResponseEntity.ok(data);
  }

  @GetMapping("/foo")
  public HttpEntity foo(@RequestParam(name = "fail", required = false, defaultValue = "false") Boolean fail) throws InterruptedException {

    System.out.println("Invocando FOO: " + System.currentTimeMillis());
    System.out.println("Deberia fallar? " + fail);

    if (fail) {
      Thread.sleep(3000);
      throw new RuntimeException("Un error no controlado.");
    }


    Map<String, Object> result = new HashMap<>();
    result.put("hola", "Extraño");

    return ResponseEntity.ok(result);
  }
}
