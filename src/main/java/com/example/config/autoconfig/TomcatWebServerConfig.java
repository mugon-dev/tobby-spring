package com.example.config.autoconfig;

import com.example.config.ConditionalMyOnClass;
import com.example.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
//@Conditional(TomcatCondition.class)
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

  @Value("${contextPath}")
  String contextPath;

  @Bean("tomcatWebServerFactory")
  @ConditionalOnMissingBean
    // 사용자 정의된 빈이 없으면 사용
  ServletWebServerFactory servletWebServerFactory() {
    TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
    serverFactory.setContextPath(this.contextPath);
    return serverFactory;
  }

//  static class TomcatCondition implements Condition {
//
//    @Override
//    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//      return ClassUtils.isPresent("org.apache.catalina.startup.Tomcat",
//          context.getClassLoader());
//    }
//  }
}
