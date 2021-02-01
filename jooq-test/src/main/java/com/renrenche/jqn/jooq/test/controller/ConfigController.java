package com.renrenche.jqn.jooq.test.controller;

import com.renrenche.jqn.jooq.test.dao.StudentDao;
import com.renrenche.rest.protocol.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiachunyi
 * @date 2018/3/25
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private StudentDao studentDao;

    @PostMapping("/{name}")
    public Response getConfigByName(@PathVariable("name") String name) {
        studentDao.insert(name);
        studentDao.update(name, name.concat("_back"));
        return Response.ok();
    }

}
