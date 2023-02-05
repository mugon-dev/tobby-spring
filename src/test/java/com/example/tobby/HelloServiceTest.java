package com.example.tobby;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloServiceTest {

  @Test
  void simpleHelloService() {
    SimpleHelloService helloService = new SimpleHelloService();
    String ret = helloService.sayHello("Test");
    assertThat(ret).isEqualTo("Test");
  }

  @Test
  void failsHelloController() {
    HelloController helloController = new HelloController(name -> name);
    Assertions.assertThatThrownBy(() -> helloController.hello(null))
              .isInstanceOf(IllegalArgumentException.class);

    Assertions.assertThatThrownBy(() -> helloController.hello(""))
              .isInstanceOf(IllegalArgumentException.class);
  }
}
