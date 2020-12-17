package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.service.BorrowServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/touser")
    public String toBorrow(){

        return "user";
    }

    @ResponseBody
    @RequestMapping("/alluser")
    public String getUser() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        System.out.println("执行成功=====》:"+mapper.selectAll());

        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(mapper.selectAll(),"yyyy-MM-dd HH:mm:ss");

    }
}
