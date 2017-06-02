package com.cacti.workshop.microservices.client.fallback;

import com.cacti.workshop.microservices.client.Client;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Collections.emptyMap;

@Service
public class ClientImpl implements Client {
  @Override
  public Map<String, Object> saluda(Boolean fail) {
    System.out.println("Problemas al invocar el servicio remoto");
    return emptyMap();
  }
}
