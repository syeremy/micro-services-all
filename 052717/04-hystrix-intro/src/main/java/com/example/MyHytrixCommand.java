package com.example;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by domix on 8/27/16.
 */
public class MyHytrixCommand extends HystrixCommand<String> {
  private final String name;

  public MyHytrixCommand(String name) {
    //El nombre del grupo esta relacionado a un ThreadPool
    super(HystrixCommandGroupKey.Factory.asKey("NombreDelGrupo"));
    this.name = name;
  }

  @Override
  protected String run() throws Exception {
    return "Hola " + name;
  }
}
