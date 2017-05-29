package com.cacti.workshop.microservices.rx;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by domix on 8/26/16.
 */
public class SseWorker implements Callable<Integer> {
  private final Integer id;

  public SseWorker(Integer id) {
    this.id = id;
  }

  @Override
  /**
    Aqui va la logica del trabajo pesado/tardado (bloqueante)
   */
  public Integer call() throws Exception {
    Random r = new Random();
    int i = r.nextInt(1000);
    Thread.sleep(i);
    System.out.println("Terminando trabajo " + id + ", result " + i);

    return i;
  }
}
