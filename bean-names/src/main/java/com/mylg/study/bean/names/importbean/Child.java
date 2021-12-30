/**
 * @author mylg
 * @date 2021-07-08
 */
package com.mylg.study.bean.names.importbean;

import org.springframework.context.annotation.Bean;

public class Child {
    private String name;

    @Bean
    public Grandson getGrandSon(){
        return new Grandson();
    }

    public Child() {
        this.name = "孩子";
    }

    public String getName() {
        return name;
    }
}
