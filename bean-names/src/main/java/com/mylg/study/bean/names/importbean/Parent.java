/**
 * @author mylg
 * @date 2021-07-08
 */
package com.mylg.study.bean.names.importbean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Child.class)
public class Parent {
    private String name;

    public Parent() {
        this.name = "父母";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Parent{" +
            "name='" + name + '\'' +
            '}';
    }
}
