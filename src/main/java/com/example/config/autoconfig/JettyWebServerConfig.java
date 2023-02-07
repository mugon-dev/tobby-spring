package com.example.config.autoconfig;

import com.example.config.ConditionalMyOnClass;
import com.example.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
//@Conditional(JettyCondition.class)
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {

  @Bean("jettyWebServerFactory")
  @ConditionalOnMissingBean
    // 사용자 정의된 빈이 없으면 사용
    // bean name 지정
  ServletWebServerFactory servletWebServerFactory() {
    return new JettyServletWebServerFactory();
  }

//  static class JettyCondition implements Condition {
//
//    @Override
//    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//      return ClassUtils.isPresent("org.eclipse.jetty.server.Server", context.getClassLoader());
//    }
//  }
}
