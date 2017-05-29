package com.cacti.workshop.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class Dia13Application {

  public static void main(String[] args) {
    SpringApplication.run(Dia13Application.class, args);
  }
}
