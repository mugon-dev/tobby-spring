package com.example.tobby;

import java.util.Objects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Meta Annotation Annotation 위에 붙은 Annotation
 */
@RestController
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping("/hello")
  public String hello(String name) {
    if(name == null || name.trim().length() == 0) throw new IllegalArgumentException();
    return helloService.sayHello(name);
  }
}
