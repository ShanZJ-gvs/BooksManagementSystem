package com.gvssimux.controller;

import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.Borrow;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.BorrowServiceImpl;
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
    public List<Borrow> getAllBorrow(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);

        System.out.println("执行成功=====》:"+mapper.selectAll());
        return mapper.selectAll();
    }
}
