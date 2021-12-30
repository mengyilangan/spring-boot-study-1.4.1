/**
 * @author mylg
 * @date 2021-07-06
 */
package com.mylg.study.bean.names.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration("factory")
public class FactoryBean {
    @Bean
    public InnerClass innerClass() {
        return new InnerClass(System.currentTimeMillis());
    }

    @Bean
    public static InnerClass innerClassStatic() {
        return new InnerClass(System.currentTimeMillis() / 1000);
    }

    @Configuration
    public static class InnerClassStaticConfiguration {
        private final LocalTime localTime = LocalTime.now();

        public LocalTime getLocalTime() {
            return localTime;
        }
    }

    @Configuration
    public class InnerClassConfiguration {
        private final LocalTime localTime = LocalTime.now();

        public LocalTime getLocalTime() {
            return localTime;
        }
    }

    public static class InnerClass {
        private final long time;

        public InnerClass(long time) {
            this.time = time;
        }

        public long getTime() {
            return time;
        }
    }
}
