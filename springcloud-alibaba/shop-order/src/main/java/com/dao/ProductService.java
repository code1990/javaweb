package com.dao;

import com.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-14 11:23
 * @Author: code1990
 * @Description:
 */
@FeignClient(value = "service-product")
public interface ProductService {

    @RequestMapping("/product/{pid}")
    Product findByPid(@PathVariable Integer pid);

}
