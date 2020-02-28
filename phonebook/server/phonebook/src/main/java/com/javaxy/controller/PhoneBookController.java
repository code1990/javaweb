package com.javaxy.controller;

import com.javaxy.entity.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wei
 * @description
 * @date 2020/2/28
 */
@RestController
@RequestMapping("/phoneBook")
public class PhoneBookController {

    /**
     * 查询所有电话簿信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/loadAll")
    public R loadAll()throws Exception{
        return R.ok("电话簿信息");
    }
}

