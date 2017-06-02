package com.cacti.workshop.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Dia14EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dia14EurekaClientApplication.class, args);
	}
}
