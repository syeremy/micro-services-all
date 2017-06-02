package com.cacti.workshop.microservices.client;

import com.cacti.workshop.microservices.client.fallback.ClientImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

// En el valor del atributo name, 'data' hace referencia al id del servicio registrado en Eureka
@FeignClient(name = "data", fallback = ClientImpl.class)
public interface Client {
  @RequestMapping(value = "/serviceDummy/foo", method = GET)
  Map<String, Object> saluda(@RequestParam("fail") Boolean fail);
}
