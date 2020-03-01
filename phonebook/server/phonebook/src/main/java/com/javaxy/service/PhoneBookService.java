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

    /**
     * 添加通讯记录
     * @param phoneBook
     * @return
     */
    Integer add(PhoneBook phoneBook);

    /**
     * 修改信息
     * @param phoneBook
     * @return
     */
    Integer update(PhoneBook phoneBook);

    /**
     * 根据id查询通讯录记录
     * @param id
     * @return
     */
    PhoneBook findById(Integer id);
}