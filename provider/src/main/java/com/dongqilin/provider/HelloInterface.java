package com.dongqilin.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: dongql
 * @date: 2019/1/8 17:19
 */
public interface HelloInterface {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
