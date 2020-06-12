package com.dao;

import com.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-12 21:52
 * @Author: code1990
 * @Description:
 */
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
}

