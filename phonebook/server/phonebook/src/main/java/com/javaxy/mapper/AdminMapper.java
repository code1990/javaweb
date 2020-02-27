package com.javaxy.mapper;

import com.javaxy.entity.Admin;

public interface AdminMapper {

    /**
     * 管理员登录
     *
     * @param admin
     * @return
     */
    Admin login(Admin admin);

}
