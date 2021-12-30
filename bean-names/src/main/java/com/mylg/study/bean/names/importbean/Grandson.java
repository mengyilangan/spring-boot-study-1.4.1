/**
 * @author mylg
 * @date 2021-07-08
 */
package com.mylg.study.bean.names.importbean;

import org.springframework.context.annotation.Import;

@Import(Father.class)
public class Grandson {
    private String name;

    public Grandson() {
        name = "孙子";
    }

    public String getName() {
        return name;
    }
}
