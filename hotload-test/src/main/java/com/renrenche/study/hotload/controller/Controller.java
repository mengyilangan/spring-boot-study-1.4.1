package com.renrenche.study.hotload.controller;

import com.renrenche.study.hotload.config.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangqiaonan
 * @date 2021/2/1
 */
@RestController
public class Controller {
    @Autowired
    private Person person;

    @GetMapping("/person")
    public String getConfigPerson() {
        return person.getFirst() + person.getLast();
    }
}
