package com.javaxy.controller;

import com.javaxy.constant.SystemConstant;
import com.javaxy.entity.Admin;
import com.javaxy.entity.R;
import com.javaxy.service.AdminService;
import com.javaxy.util.JwtUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public R login(@RequestBody Admin admin)throws Exception{
        Admin u=adminService.login(admin);
        R r=new R();
        if(u==null){
            return R.error("用户名或者密码错误");
        } else {
            String token = JwtUtils.createJWT(String.valueOf(u.getId()), u.getUserName(), SystemConstant.JWT_TTL);
            r.put("token", token);
        }
        return r;
    }

}