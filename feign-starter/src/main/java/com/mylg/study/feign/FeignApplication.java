/**
 * @author mylg
 * @date 2021-06-19
 */
package com.mylg.study.feign;

import com.mylg.study.feign.configuration.FeignConfigurationV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(defaultConfiguration = FeignConfigurationV2.class)
@SpringBootApplication
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
