package com.javaxy.controller;

import com.javaxy.entity.PhoneBook;
import com.javaxy.entity.R;
import com.javaxy.service.PhoneBookService;
import com.javaxy.util.PinYinUtil;
import com.javaxy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 添加或者修改通讯记录
     * @param phoneBook
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public R save(@RequestBody PhoneBook phoneBook)throws Exception{
        int resultTotal=0;
        String initial=String.valueOf(PinYinUtil.getPinYin(phoneBook.getName()).charAt(0)).toUpperCase();
        if(StringUtil.isAlpha(initial)){
            phoneBook.setInitial(initial);
        }else{
            phoneBook.setInitial("#");
        }
        if(phoneBook.getId()==null){
            resultTotal=phoneBookService.add(phoneBook);
        }else{

        }
        if(resultTotal>0){
            return R.ok();
        }else{
            return R.error(-1,"保存失败，请联系管理员");
        }
    }
}