/**
 * @author mylg
 * @date 2021-06-23
 */
package com.mylg.study.tomcat.config;

import org.jboss.logging.MDC;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.UUID;

@Configuration
public class RequestAop {
    @Bean
    public ServletRequestListener requestListener() {
        return new ServletRequestListener() {
            @Override
            public void requestDestroyed(ServletRequestEvent sre) {
            }

            @Override
            public void requestInitialized(ServletRequestEvent sre) {
                MDC.put("request_id", UUID.randomUUID().toString().replace("-", ""));
            }
        };
    }

    @Bean
    public ServletListenerRegistrationBean<ServletRequestListener> servletListenerRegistrationBean(ServletRequestListener servletRequestListener) {
        ServletListenerRegistrationBean<ServletRequestListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
        servletListenerRegistrationBean.setListener(servletRequestListener);
        return servletListenerRegistrationBean;
    }
}
