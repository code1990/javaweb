package com.service.fallback;

import com.Product;
import com.service.ProductService;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-14 19:56
 * @Author: code1990
 * @Description:
 */
@Component
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product findByPid(Integer pid) {
        Product product = new Product();
        product.setPid(-100);
        product.setPname("error");
        return product;
    }
}
