package com.example;

/**
 * Created by domix on 8/27/16.
 */
@org.springframework.stereotype.Service
public class Service {
  public String saludo(String name) {
    MyHytrixCommand command = new MyHytrixCommand(name);
    return command.execute();
  }
}
