package com.dongqilin.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: dongql
 * @date: 2019/1/8 17:20
 */
@RestController
@RefreshScope
public class HelloController implements HelloInterface{

    @Value("${server.port}")
    private String port = "";

    @Value("${label}")
    private String label = "";

    @Autowired
    DiscoveryClient client;

    @Override
    public String hello(@RequestParam(value = "name") String name){
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("hosts: "+instance.getHost()+",serverId:" +instance.getServiceId());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hi "+name+",i am from port:" +port +",label:"+label;
    }
}
