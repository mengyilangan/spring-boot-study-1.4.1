/**
 * @author mylg
 * @date 2021-06-20
 */
package com.mylg.study.feign.controller;

import com.mylg.study.feign.clients.GreetingClient;
import com.mylg.study.feign.clients.JSONPlaceHolderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @Autowired
    private GreetingClient client;

    @Autowired
    private JSONPlaceHolderClient jsonPlaceHolderClient;

    @GetMapping(path = "/greet")
    public String get() {
        client.hello();
        return "hello";
    }

    @GetMapping(path = "/json")
    public String json() {
        jsonPlaceHolderClient.getPosts();
        return "hello";
    }
}
