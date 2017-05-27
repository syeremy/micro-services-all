package com.cacti.workshop.microservices.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by domix on 8/20/16.
 */
@Configuration
public class RabbitConfig {
  public final static String queueName = "queueDemo";
  public final static String queuePeople = "queuePeople";


  @Bean
  Queue queuePeople() {
    return new Queue(queuePeople);
  }

  @Bean
  DirectExchange exchangePeople() {
    return new DirectExchange("exchangePersonas");
  }

  @Bean
  Binding bindingPeople(Queue queuePeople, DirectExchange exchangePeople) {
    //Tie queue with exchange using naming convention (same name)
    return BindingBuilder.bind(queuePeople).to(exchangePeople).withQueueName();
  }


  @Bean
  Queue queue() {
    return new Queue(queueName);
  }

  @Bean
  TopicExchange exchange() {
    return new TopicExchange("exchange-demo");
  }

  @Bean
  Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(queueName);
  }
}
