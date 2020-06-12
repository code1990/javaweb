package com.dao;

import com.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: springcloud-alibaba
 * @Date: 2020-06-12 21:55
 * @Author: code1990
 * @Description:
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
