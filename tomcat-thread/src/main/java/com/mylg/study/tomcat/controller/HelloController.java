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
    private ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            long threadId = Thread.currentThread().getId();
            String threadName = Thread.currentThread().getName();
            System.out.println("设置初始值,threadId=" + threadId + ";threadName=" + threadName);
            return threadName;
        }

        @Override
        public void remove() {
            super.remove();
            long threadId = Thread.currentThread().getId();
            String threadName = Thread.currentThread().getName();
            System.out.println("清理,threadId=" + threadId + ";threadName=" + threadName);
        }
    };

    @GetMapping(path = "/hello")
    public String Hello() {
        String requestId = MDC.get("request_id");
        System.out.println("time=" + System.currentTimeMillis() + ";request_id=" + requestId + ";thread_id=" + Thread.currentThread().getId());
        return requestId;
    }
}
