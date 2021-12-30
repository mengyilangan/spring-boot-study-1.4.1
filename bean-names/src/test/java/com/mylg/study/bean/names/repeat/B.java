/**
 * @author mylg
 * @date 2021-07-09
 */
package com.mylg.study.bean.names.repeat;

import org.springframework.context.annotation.Bean;

public interface B extends A {
    @Bean
    C c();
}
