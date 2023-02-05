package com.example.tobby;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
@Configuration
@ComponentScan // @Component 붙은 Class 찾아 Bean 등록
public class TobbyApplication {

  @Bean ServletWebServerFactory servletWebServerFactory(){
    return new TomcatServletWebServerFactory();
  }
  @Bean
  public DispatcherServlet dispatcherServlet(){
    // ApplicationContextAware 인터페이스를 받아 구현했기때문에 Bean으로 등록되면 spring container에 등록해줌
    return new DispatcherServlet();
  }

  public static void main(String[] args) {
    MySpringApplication.run(TobbyApplication.class,  args);
  }
}
