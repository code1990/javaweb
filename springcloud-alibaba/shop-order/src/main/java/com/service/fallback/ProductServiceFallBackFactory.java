package com.service.fallback;

import com.Product;
import com.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-14 20:14
 * @Author: code1990
 * @Description:
 */
@Component
public class ProductServiceFallBackFactory implements FallbackFactory<ProductService> {
    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {
            @Override
            public Product findByPid(Integer pid) {
                throwable.printStackTrace();
                Product product = new Product();
                product.setPid(-100);
                product.setPname("error");
                return product;
            }
        };
    }
}
