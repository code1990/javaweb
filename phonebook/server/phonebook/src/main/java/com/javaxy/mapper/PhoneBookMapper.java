package com.javaxy.mapper;

import com.javaxy.entity.PhoneBook;

import java.util.List;

/**
 * @author wei
 * @description
 * @date 2020/2/28
 */
public interface PhoneBookMapper {

    /**
     * 根据姓名首字母查询电话簿记录
     * @param initial
     * @return
     */
    List<PhoneBook> loadByInitial(String initial);
}

