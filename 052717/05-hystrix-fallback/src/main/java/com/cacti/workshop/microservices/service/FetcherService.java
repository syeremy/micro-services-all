package com.cacti.workshop.microservices.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by domix on 8/29/16.
 */
@Service
public class FetcherService {
  private final RestTemplate restTemplate;

  public FetcherService() {
    this.restTemplate = new RestTemplate();
  }

  public ResponseEntity<String> fetch(String url) {
    return restTemplate
      .getForEntity(url, String.class);
  }

  @HystrixCommand(fallbackMethod = "fetchJavanicaFallback")
  public String fetchJavanica(String url) {
    return restTemplate
      .getForEntity(url, String.class).getBody();
  }

  public String fetchJavanicaFallback(String url) {
    return "la url: " + url + ", no se pudo obtener";
  }
}
