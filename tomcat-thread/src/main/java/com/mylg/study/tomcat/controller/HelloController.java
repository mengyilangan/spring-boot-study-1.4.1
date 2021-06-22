/**
 * @author mylg
 * @date 2021-06-23
 */
package com.mylg.study.tomcat.controller;

import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "/hello")
    public String Hello() {
        String requestId = MDC.get("request_id");
        System.out.println("time=" + System.currentTimeMillis() + ";request_id=" + requestId);
        return requestId;
    }
}
