/**
 * @author jiangqiaonan
 * @date 2021-06-19
 */
package com.mylg.study.feign.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder.Default();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        System.out.println("requestInterceptor new ~~~~");
        return requestTemplate -> {
            System.out.println("requestInterceptor----------from FeignConfiguration");
            requestTemplate.header("user", "murphy");
            requestTemplate.header("password", "abc123");
        };
    }
}
