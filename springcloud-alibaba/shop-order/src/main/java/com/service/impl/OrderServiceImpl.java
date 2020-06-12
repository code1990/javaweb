package com.service.impl;

import com.Order;
import com.dao.OrderDao;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-12 21:53
 * @Author: code1990
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

}
