package com.service.impl;

import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-12 21:57
 * @Author: code1990
 * @Description:
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserDao userDao;
}
