package com.javaxy.service.impl;

import com.javaxy.entity.Admin;
import com.javaxy.mapper.AdminMapper;
import com.javaxy.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2020-02-27 15:19:17
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        return adminMapper.login(admin);
    }
}