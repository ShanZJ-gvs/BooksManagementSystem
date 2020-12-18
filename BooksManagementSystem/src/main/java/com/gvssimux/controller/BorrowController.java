package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.Borrow;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.BorrowServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BorrowController {


    @RequestMapping("/toborrow")
    public String toBorrow(){

        return "borrow";
    }

    @ResponseBody
    @RequestMapping("/allborrow")
    public String getAllBorrow() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);
        System.out.println("执行成功=====》:"+mapper.selectAll());

        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(mapper.selectAll(),"yyyy-MM-dd HH:mm:ss");

    }


    @ResponseBody
    @RequestMapping("/permonth")
    public String getPerMonth() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);
        int[] ints = new int[12];
        for (int i = 0; i < 12; i++) {
            int j = i +1;
            ints[i] = mapper.getPerSum("%-"+j+"-%");
        }
        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(ints,"yyyy-MM-dd HH:mm:ss");

    }


}
