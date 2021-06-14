package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.service.BorrowServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {


    @ResponseBody
    @RequestMapping("/allmessage")
    public String getAllBorrow() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);
        System.out.println("执行成功=====》:"+mapper.get3Table());

        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(mapper.get3Table(),"yyyy-MM-dd HH:mm:ss");

    }

    @ResponseBody
    @RequestMapping("/waitout")
    public String waitout() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);
        System.out.println("执行成功=====》:"+mapper.get3Table2());

        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(mapper.get3Table2(),"yyyy-MM-dd HH:mm:ss");

    }
}
