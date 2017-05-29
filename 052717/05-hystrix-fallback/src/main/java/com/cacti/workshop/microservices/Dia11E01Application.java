package com.cacti.workshop.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//Habilita el stream de eventos de las metricas de Hystrix
@EnableHystrix
//Habilita un UI para ver el flujo de eventos
@EnableHystrixDashboard
public class Dia11E01Application {

  public static void main(String[] args) {
    SpringApplication.run(Dia11E01Application.class, args);
  }

  @Bean
  HealthIndicator customHardcodedHealthIndicator() {
    return new AbstractHealthIndicator() {

      @Override
      protected void doHealthCheck(Health.Builder builder) throws Exception {
        String user = "domix";
        builder
          .withDetail("user", user)
          .up();
      }
    };
  }
}
