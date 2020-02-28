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
@RequestMapping("phoneBook")
public class PhoneBookController {
    @RequestMapping("/loadAll")
    public R loadAll() throws Exception{
        return R.ok("电话薄信息");
    }
}

