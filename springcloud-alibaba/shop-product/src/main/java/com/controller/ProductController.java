package com.controller;

import com.Product;
import com.alibaba.fastjson.JSONObject;
import com.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-12 21:37
 * @Author: code1990
 * @Description:
 */
@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{pid}")
    public Product getProductByPid(@PathVariable("pid") Integer pid){
        Product product = productService.getProductByPid(pid);
        log.info("{}",JSONObject.toJSONString(product));
        return product;
    }


}
