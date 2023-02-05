package com.example.tobby;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Test
@interface UnitTest{

}
public class HelloServiceTest {

  @UnitTest
  void simpleHelloService() {
    SimpleHelloService helloService = new SimpleHelloService();
    String ret = helloService.sayHello("Test");
    assertThat(ret).isEqualTo("Hello Test");
  }

  @Test
  void helloDecorator(){
    HelloDecorator decorator = new HelloDecorator(name->name);
    String ret = decorator.sayHello("Test");
    assertThat(ret).isEqualTo("*Test*");
  }
}
