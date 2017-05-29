package com.cacti.workshop.microservices.hystrix;

import com.cacti.workshop.microservices.service.FetcherService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by domix on 8/29/16.
 */
public class FetcherCommand extends HystrixCommand<String> {
  private final FetcherService fetcherService;
  private final String url;

  public FetcherCommand(FetcherService fetcherService, String url) {
    //GroupKey indica el ThreadPool que usará
    super(HystrixCommandGroupKey.Factory.asKey("Fetcher"));
    this.fetcherService = fetcherService;
    this.url = url;
  }

  @Override
  protected String run() throws Exception {
    return fetcherService.fetch(url).getBody();
  }

  @Override
  protected String getFallback() {
    Throwable failedExecutionException = getFailedExecutionException();
    return "la url: " + url + ", no se pudo obtener, debido a: " + failedExecutionException.getMessage();
  }
}
