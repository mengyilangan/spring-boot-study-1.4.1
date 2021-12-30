/**
 * @author mylg
 * @date 2021-06-19
 */
package com.mylg.study.feign.clients;

import com.mylg.study.feign.configuration.FeignConfigurationV1;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "greet-client", url = "http://www.baidu.com/", configuration = FeignConfigurationV1.class)
public interface GreetingClient {
    @RequestMapping(method = RequestMethod.GET, value = "{url}")
    List hello(@PathVariable("url") String url);
}
