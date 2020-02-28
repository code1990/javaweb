package com.javaxy.service;

import com.javaxy.entity.PhoneBook;

import java.util.List;



/**
 * (TPhonebook)表服务接口
 *
 * @author makejava
 * @since 2020-02-28 23:19:08
 */
public interface PhoneBookService {

    /**
     * 根据姓名首字母查询电话簿记录
     * @param initial
     * @return
     */
    List<PhoneBook> loadByInitial(String initial);

}