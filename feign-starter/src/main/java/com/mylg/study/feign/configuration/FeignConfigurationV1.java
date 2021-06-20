/**
 * @author jiangqiaonan
 * @date 2021-06-19
 */
package com.mylg.study.feign.configuration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class FeignConfigurationV1 {

    @Bean
    public RequestInterceptor requestInterceptor() {
        System.out.println("requestInterceptor new ~~~~from FeignConfigurationV1");
        return requestTemplate -> {
            System.out.println("requestInterceptor----------from FeignConfigurationV1");
            requestTemplate.header("user", "murphy");
            requestTemplate.header("password", "abc123");
        };
    }
}
