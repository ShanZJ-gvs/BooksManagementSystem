package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.BookInf;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.CommentServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
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

    /**
     * 单个查询
     */
    @ResponseBody
    @RequestMapping("/onebook")
    public String getOneBook(String isbn) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        System.out.println(isbn);
        return jsonUtil.getJson(bookInfServiceImpl.getBookByIsbn(isbn));
    }


    /**
     * 部分修改
     */
    @ResponseBody
    @RequestMapping("/bookchange")
    public String changeBook(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        //创建接收对象
        BookInf object = new BookInf();
        object.setIsbn(request.getParameter("isbn"));
        object.setBookName(request.getParameter("bookName"));
        object.setBookAuthor(request.getParameter("bookAuthor"));
        object.setBookPublish(request.getParameter("bookPublish"));
        object.setBookIntroduction(request.getParameter("bookIntroduction"));
        object.setBookType(request.getParameter("bookType"));
        object.setMoney(request.getParameter("money"));
        object.setSum(Integer.valueOf(request.getParameter("sum")));
        object.setNum(Integer.valueOf(request.getParameter("num")));
        object.setId(Integer.valueOf(request.getParameter("bookId")));

        bookInfServiceImpl.updateByPrimaryKeySelective(object);
        //System.out.println("======================"+request.getParameter("bookName")+"====================");
        return jsonUtil.getJson(object.getIsbn());
    }

    /**
     * 查询书籍评论
     */
    @ResponseBody
    @RequestMapping("/getcomm")
    public String getComment(String isbn) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CommentServiceImpl mapper = context.getBean("CommentServiceImpl", CommentServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        System.out.println(isbn);
        return jsonUtil.getJson(mapper.getCommentByIsbn(isbn));
    }

    /**
     * 模糊查询
     */

    @RequestMapping("/search")
    public void getA(HttpServletRequest request, HttpServletResponse response){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        //创建接收对象
        BookInf object = new BookInf();
        object.setIsbn(request.getParameter("bookIsbn"));
        object.setBookName(request.getParameter("bookName"));
        object.setBookAuthor(request.getParameter("bookAuthor"));
        object.setBookPublish(request.getParameter("bookPublish"));
        object.setBookType(request.getParameter("bookType"));
        object.setId(Integer.valueOf(request.getParameter("bookId")));

        System.out.println("执行成功=====》:"+bookInfServiceImpl.searchBook(object));
    }


}
