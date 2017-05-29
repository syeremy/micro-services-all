package com.cacti.workshop.microservices.rx;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import rx.Observer;

import java.io.IOException;

/**
 * Created by domix on 8/26/16.
 */
public class SseObserver implements Observer<Integer> {
  private final SseEmitter emitter;

  public SseObserver(SseEmitter emitter) {
    this.emitter = emitter;
  }

  @Override
  public void onCompleted() {
    emitter.complete();
  }

  @Override
  public void onError(Throwable e) {
    emitter.completeWithError(e);
  }

  @Override
  public void onNext(Integer integer) {
    try {
      emitter.send(integer);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
