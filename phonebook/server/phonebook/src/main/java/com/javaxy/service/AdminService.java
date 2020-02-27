package com.javaxy.service;

import com.javaxy.entity.Admin;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2020-02-27 15:19:17
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param admin 主键
     * @return 实例对象
     */
    public Admin login(Admin admin);

}