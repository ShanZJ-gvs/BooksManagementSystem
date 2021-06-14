package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.BorrowServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class UserController {
    @ResponseBody
    @RequestMapping("/alluser")
    public String getUser() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        System.out.println("执行成功=====》:"+mapper.selectAll());

        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(mapper.selectAll(),"yyyy-MM-dd HH:mm:ss");

    }



    //给nav的四给卡片传数值
    @ResponseBody
    @RequestMapping("/nav")
    public String getUserNum() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        BorrowServiceImpl mapper2 = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);
        BookInfServiceImpl mapper3 = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        Date date = new Date();
        int[] ints = {mapper3.getBookNum(), mapper.getUserNum(), mapper2.getBorrowNum(),mapper2.getOverNum(date)};
        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(ints);
    }

}
