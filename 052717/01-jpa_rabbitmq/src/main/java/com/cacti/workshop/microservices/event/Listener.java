package com.cacti.workshop.microservices.event;

import com.cacti.workshop.microservices.config.RabbitConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Map;

import static com.cacti.workshop.microservices.config.RabbitConfig.queueName;

/**
 * Created by domix on 8/20/16.
 */
@Component
public class Listener {

  private final ObjectMapper objectMapper;

  public Listener(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @RabbitListener(queues = RabbitConfig.queueName)
  public void listen(Message message) throws Exception {
    Thread.sleep(SecureRandom.getInstanceStrong().nextInt(10000));
    String body = new String(message.getBody());

    Map valorRecibido = objectMapper.readValue(body, Map.class);
    Long en = (Long) valorRecibido.get("enviado");
    Date enviado = new Date(en);

    valorRecibido.put("recibidoDate", new Date().toString());
    valorRecibido.put("enviadoDate", enviado.toString());

    System.out.println(objectMapper.writeValueAsString(valorRecibido));
  }
}
