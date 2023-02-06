package com.example.config.autoconfig;

import com.example.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
public class JettyWebServerConfig {

  @Bean("jettyWebServerFactory")
    // bean name 지정
  ServletWebServerFactory servletWebServerFactory() {
    return new JettyServletWebServerFactory();
  }
}
