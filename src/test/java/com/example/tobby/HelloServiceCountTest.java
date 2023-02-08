package com.example.tobby;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class HelloServiceCountTest {

  @Autowired
  HelloService helloService;
  @Autowired
  HelloRepository helloRepository;

  @Test
  void sayHelloIncreaseCount() {
    helloService.sayHello("Toby");
    assertThat(helloRepository.countOf("Toby")).isEqualTo(1);
  }

}
