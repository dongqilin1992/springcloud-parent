package com.dongqilin.consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: dongql
 * @date: 2019/1/11 14:55
 */
@Component
public class HelloFallback implements HelloFeginClient{
    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "出错啦";
    }
}
