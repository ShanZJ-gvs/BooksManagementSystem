package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.BookInf;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Controller
public class BookInfController {

    /**
     * 跳转页面
     */
    @RequestMapping("/tobookinf")
    public String toBookInf(Model model){

        return "bookinf";
    }


    @ResponseBody
    @RequestMapping("/onebook")
    public BookInf allBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        return bookInfServiceImpl.selectByPrimaryKey(2);
    }

    /**
     * 全部查询
     */
    @ResponseBody
    @RequestMapping("/allbook")
    public String getAllBook() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        System.out.println("执行成功=====》:"+bookInfServiceImpl.selectAll());
        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(bookInfServiceImpl.selectAll());
    }


}
