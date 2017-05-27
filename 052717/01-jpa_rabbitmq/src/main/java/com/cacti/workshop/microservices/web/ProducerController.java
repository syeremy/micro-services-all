package com.cacti.workshop.microservices.web;

import com.cacti.workshop.microservices.config.RabbitConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by domix on 8/20/16.
 */
@RestController
public class ProducerController {
  private final RabbitTemplate rabbitTemplate;
  private final ObjectMapper objectMapper;

  public ProducerController(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
    this.rabbitTemplate = rabbitTemplate;
    this.objectMapper = objectMapper;
  }

  @PostMapping("/queue")
  public HttpEntity queue(@RequestBody Map data) throws JsonProcessingException {
    data.put("enviado", System.currentTimeMillis());
    rabbitTemplate.convertAndSend(RabbitConfig.queueName, objectMapper.writeValueAsString(data));

    return ResponseEntity.ok(true);
  }
}
