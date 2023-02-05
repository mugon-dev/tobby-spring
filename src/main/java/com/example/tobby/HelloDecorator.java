package com.example.tobby;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // 우선적으로 auto wired 적용
public class HelloDecorator implements HelloService {

  private final HelloService helloService;

  public HelloDecorator(HelloService helloService) {
    this.helloService = helloService;
  }

  @Override
  public String sayHello(String name) {
    return "*" + helloService.sayHello(name) + "*";
  }
}
