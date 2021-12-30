/**
 * @author mylg
 * @date 2021-07-09
 */
package com.mylg.study.bean.names.repeat;

import org.springframework.context.annotation.Bean;

public interface A {
    @Bean
    default  C ac(){
        return new C();
    }
}
