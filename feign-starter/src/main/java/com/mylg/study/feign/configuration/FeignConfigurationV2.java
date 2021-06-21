/**
 * @author mylg
 * @date 2021-06-20
 */
package com.mylg.study.feign.configuration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({ A.class, AWithConfiguration.class })
public class FeignConfigurationV2 {
    @Bean
    public RequestInterceptor requestInterceptor() {
        System.out.println("requestInterceptor new ~~~~from FeignConfigurationV2");
        return requestTemplate -> {
            System.out.println("requestInterceptor----------from FeignConfigurationV2");
            requestTemplate.header("user", "murphy");
            requestTemplate.header("password", "abc123");
        };
    }
}
