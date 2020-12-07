package com.gvssimux.controller;

import com.gvssimux.pojo.BookInf;
import com.gvssimux.service.BookInfServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@Controller
public class BookInfController {

    /**
     * 根据id查询
     */
    @RequestMapping("/tobookinf")
    public String toBookInf(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        return "bookinf";
    }


    @ResponseBody
    @RequestMapping("/allbook")
    public BookInf allBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        return bookInfServiceImpl.selectByPrimaryKey(6);
    }







}
