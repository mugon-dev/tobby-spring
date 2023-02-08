package com.example.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;

//@MyAutoConfiguration
public class ServerPropertiesConfig {

  //  @Bean
  public ServerProperties serverProperties(Environment environment) {
//    ServerProperties properties = new ServerProperties();
//    properties.setContextPath(environment.getProperty("contextPath"));
//    properties.setPort(Integer.parseInt(environment.getProperty("port")));
//    return properties;
    return Binder.get(environment).bind("", ServerProperties.class).get();
  }
}
