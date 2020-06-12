package com.service.impl;

import com.dao.ProductDao;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-12 21:47
 * @Author: code1990
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;


}
