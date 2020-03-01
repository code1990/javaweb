package com.javaxy.service.impl;

import com.javaxy.entity.PhoneBook;
import com.javaxy.mapper.PhoneBookMapper;
import com.javaxy.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (TPhonebook)表服务实现类
 *
 * @author makejava
 * @since 2020-02-28 23:19:08
 */
@Service("phoneBookService")
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private PhoneBookMapper phoneBookMapper;

    @Override
    public List<PhoneBook> loadByInitial(String initial) {
        return phoneBookMapper.loadByInitial(initial);
    }

    @Override
    public Integer add(PhoneBook phoneBook) {
        return phoneBookMapper.add(phoneBook);
    }
}