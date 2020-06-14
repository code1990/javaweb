package com.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-14 14:29
 * @Author: code1990
 * @Description:
 */
@RestController
@Slf4j
public class OrderController3 {
    @RequestMapping("/order/message1")
    public String message1() {
        return "message1";
    }
    @RequestMapping("/order/message2")
    public String message2() {
        return "message2";
    }
}
