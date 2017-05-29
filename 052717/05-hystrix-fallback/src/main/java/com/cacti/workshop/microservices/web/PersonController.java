package com.cacti.workshop.microservices.web;

import com.cacti.workshop.microservices.hystrix.FetcherCommand;
import com.cacti.workshop.microservices.service.FetcherService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by domix on 8/29/16.
 */
@RestController
@RequestMapping("/person")
public class PersonController {
  private final FetcherService fetcherService;

  public PersonController(FetcherService fetcherService) {
    this.fetcherService = fetcherService;
  }

  @GetMapping
  HttpEntity read(@RequestParam("url") String url) {

    Map<String, Object> person = new HashMap<>();
    person.put("name", "Domingo");

    //Se recomiendo usar siemrpe una instancia del Comando "limpia"
    FetcherCommand fetcher = new FetcherCommand(fetcherService, url);

    //ejecución sincrona
    person.put("Home", fetcher.execute());
    //ejecución asincrona
    //fetcher.queue();


    return ResponseEntity.ok(person);
  }

  @GetMapping("/javanica")
  HttpEntity readJavanica(@RequestParam("url") String url) {

    Map<String, Object> person = new HashMap<>();
    person.put("name", "Domingo");

    person.put("Home", fetcherService.fetchJavanica(url));

    return ResponseEntity.ok(person);
  }
}
