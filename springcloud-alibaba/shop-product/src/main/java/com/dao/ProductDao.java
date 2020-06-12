package com.dao;

import com.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-12 21:42
 * @Author: code1990
 * @Description:
 */
public interface ProductDao extends JpaRepository<Product,Integer> {

}
