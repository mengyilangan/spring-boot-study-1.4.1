/**
 * @author jiangqiaonan
 * @date 2021-06-05
 */
package com.mylg.study.bean.names.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    private com.mylg.study.bean.names.config.Person config;

    @Autowired
    private com.mylg.study.bean.names.repeat.Person repeat;

    @GetMapping("/config")
    public String getConfig() {
        return config.getName();
    }

    @GetMapping("/repeat")
    public String getRepeat() {
        return repeat.getName();
    }

}
