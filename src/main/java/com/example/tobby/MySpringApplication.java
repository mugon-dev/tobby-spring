package com.example.tobby;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MySpringApplication {
  public static void run(Class<?> applicationClass, String... args) {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
      @Override
      protected void onRefresh() {
        super.onRefresh();
        ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
        DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
        // bean으로 지정해줬기 때문에 자동으로 spring container에 등록
        // dispatcherServlet.setApplicationContext(this); // spring container 지정

        WebServer webServer = serverFactory.getWebServer(servletContext -> {
          servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                        .addMapping("/*");
        });
        webServer.start();
      }
    };
    applicationContext.register(applicationClass);
    applicationContext.refresh();
  }
}
