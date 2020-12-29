package com.gvssimux.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.service.UserWantServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserWantController {
    @RequestMapping("/touserwant")
    public String toBorrow(){

        return "userwant";
    }

    @ResponseBody
    @RequestMapping("/alluserwant")
    public String getUser() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserWantServiceImpl mapper = context.getBean("UserWantServiceImpl", UserWantServiceImpl.class);
        System.out.println("执行成功=====》:"+mapper.getAll());

        JSON.toJSON(mapper.getAll()).toString();
        return JSON.toJSON(mapper.getAll()).toString();

    }

}
