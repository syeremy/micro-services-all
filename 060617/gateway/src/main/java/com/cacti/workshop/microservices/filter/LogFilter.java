package com.cacti.workshop.microservices.filter;

import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by domix on 9/14/16.
 */
@Slf4j
@Component
public class LogFilter extends ZuulFilter {
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    log.info("Ejecutando el filtro PRE en el API Gateway");

    return null;
  }
}
