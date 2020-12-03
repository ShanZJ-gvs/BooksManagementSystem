package com.gvssimux.controller;

import com.gvssimux.pojo.BookInf;
import com.gvssimux.service.BookInfServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class BookInfController {
    /**
     * 根据id查询
     */

    @RequestMapping("/test")
    public BookInf test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        return bookInfServiceImpl.selectByPrimaryKey(2);
    }


}
