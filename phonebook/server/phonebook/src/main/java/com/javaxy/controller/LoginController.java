package com.javaxy.controller;

import com.javaxy.entity.Admin;
import com.javaxy.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2020-02-27 15:19:18
 */
@RestController
@RequestMapping("/")
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 通过主键查询单条数据
     *
     * @param admin 主键
     * @return 单条数据
     */
    @RequestMapping("/login")
    public String login(Admin admin) {
        return "login";
    }

}