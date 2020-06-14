package com.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.service.fallback.OrderServiceImpl3BlockHandlerClass;
import com.service.fallback.OrderServiceImpl3FallbackClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-14 16:29
 * @Author: code1990
 * @Description:
 */
//方式二: 将限流和降级方法外置到单独的类中
@Service
@Slf4j
public class OrderServiceImpl4 {
    int i = 0;
    @SentinelResource(
            value = "message",
            blockHandlerClass = OrderServiceImpl3BlockHandlerClass.class,
            blockHandler = "blockHandler",
            fallbackClass = OrderServiceImpl3FallbackClass.class,
            fallback = "fallback"
    )
    public String message() {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        return "message4";
    }
}
