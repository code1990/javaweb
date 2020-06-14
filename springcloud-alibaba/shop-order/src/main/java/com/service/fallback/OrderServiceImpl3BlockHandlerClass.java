package com.service.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-14 16:30
 * @Author: code1990
 * @Description:
 */
@Slf4j
public class OrderServiceImpl3BlockHandlerClass {
    //注意这里必须使用static修饰方法
    public static String blockHandler(BlockException ex) {
        log.error("{}", ex);
        return "接口被限流或者降级了...";
    }
}
