package com.dongqilin.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: dongql
 * @date: 2018/4/11 16:46
 */
@Service
public class HelloService {
    @Autowired
    HelloFeginClient client;

    //@HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        System.out.println("开始fegin调用。。。");
        //throw new RuntimeException("busy");
        return client.hello(name);

    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
