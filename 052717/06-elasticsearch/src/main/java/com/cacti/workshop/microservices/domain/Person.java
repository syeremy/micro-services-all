package com.cacti.workshop.microservices.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by domix on 9/5/16.
 */
@Document(
  indexName = "people",
  type = "person",
  shards = 10,
  replicas = 1)
public class Person {
  @Id
  private String id;

  private String nombre;
  private String apellidos;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }
}
