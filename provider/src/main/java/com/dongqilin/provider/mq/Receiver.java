package com.dongqilin.provider.mq;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: dongql
 * @date: 2019/1/10 10:45
 */
@Component
//@RabbitListener(queues = "hello")
public class Receiver {

    //@RabbitHandler
    public void receive(String hello){
        System.out.println("Receive msg:" + hello);
    }
}
