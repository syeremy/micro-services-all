package com.cacti.workshop.microservices;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Dia14EurekaServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(Dia14EurekaServerApplication.class, args);
  }
}
