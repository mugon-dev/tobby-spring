package com.example.tobby;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

//@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {

  @Bean
  ServletWebServerFactory customerWebServerFactory() {
    TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    serverFactory.setPort(9090);
    return serverFactory;
  }
}
