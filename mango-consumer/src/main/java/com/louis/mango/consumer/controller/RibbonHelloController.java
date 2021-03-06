package com.louis.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 使用RestTemplate模板实现负载均衡，与feign均属于负载均衡。
 * 
 * ribbon需要自己构建http请求，模拟http请求然后使用RestTemplate发送给其他服务，步骤相当繁琐
 * Created by liyue
 * Time 2019-09-25 11:01
 */
@RestController
public class RibbonHelloController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/ribbon/call")
    public String cal(){
        // 调用服务, service-producer为注册的服务名称，LoadBalancerInterceptor会拦截调用并根据服务名找到对应的服务
        String callServiceResult = restTemplate.getForObject("http://mango-producer/hello", String.class);

        return callServiceResult;
    }
}
