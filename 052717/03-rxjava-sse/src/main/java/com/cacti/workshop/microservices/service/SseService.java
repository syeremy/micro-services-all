package com.cacti.workshop.microservices.service;

import com.cacti.workshop.microservices.rx.SseWorker;
import com.cacti.workshop.microservices.rx.SseObserver;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import rx.Observable;
import rx.functions.Func1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by domix on 8/26/16.
 */
@Service
public class SseService {

  private final TaskExecutor taskExecutor;

  public SseService(TaskExecutor taskExecutor) {
    this.taskExecutor = taskExecutor;
  }

  @Async
  public void queueWork(SseEmitter emitter, Integer count) throws InterruptedException {
    List<Observable<Integer>> observables = IntStream.range(0, count)
      //Creo un Futuro que el taskExecutor procesara en algun momento
      .mapToObj(value -> ((ThreadPoolTaskExecutor) taskExecutor).submit(new SseWorker(value)))
      //Obtengo un Observable del futuro que se creo arriba
      .map(Observable::from)
      //Genero una lista de Observables
      .collect(Collectors.toList());

    //Combino la lista de observables en un solo Observable
    Observable.merge(observables)
      //Aplico a un solo Observable el componente que sabe como hablar por SSE
      .subscribe(new SseObserver(emitter));
  }
}
