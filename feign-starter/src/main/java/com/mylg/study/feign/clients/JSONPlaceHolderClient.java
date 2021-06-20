package com.mylg.study.feign.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author jiangqiaonan
 * @date 2021-06-19
 */
@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface JSONPlaceHolderClient {
    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List getPosts();
}
