package com.dongqilin.provider.mq;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: dongql
 * @date: 2019/1/10 10:43
 */

@Component
public class Sender {
    //@Autowired AmqpTemplate template;

    public void send(){
        //template.convertAndSend("hello","send msq:"+ new Date());
    }
}
