package com.javaxy.controller;

import com.javaxy.entity.PhoneBook;
import com.javaxy.entity.R;
import com.javaxy.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * (TPhonebook)表控制层
 *
 * @author makejava
 * @since 2020-02-28 23:19:08
 */
@RestController
@RequestMapping("/phoneBook")
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    /**
     * 通过主键查询单条数据
     *
     *
     * @return 单条数据
     */
    @RequestMapping("/loadAll")
    public R loadAll()throws Exception{
        Map<String,Object> map=new LinkedHashMap<>();
        char []letters={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','#'};
        for(int i=0;i<letters.length;i++){
            String letter=String.valueOf(letters[i]);
            List<PhoneBook> phoneBooks = phoneBookService.loadByInitial(letter);
            if(phoneBooks.size()>0){
                map.put(letter,phoneBooks);
            }
        }
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("data",map);
        return R.ok(resultMap);
    }


}