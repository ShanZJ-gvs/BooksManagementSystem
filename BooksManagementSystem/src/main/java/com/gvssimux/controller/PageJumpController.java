package com.gvssimux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageJumpController {

    /**
     * 跳转页面
     */
    @RequestMapping("/tobookinf")
    public String toBookInf(Model model){

        return "bookinf";
    }


    @RequestMapping("/toborrow")
    public String toBorrow(){

        return "borrow";
    }



    /**
     * 点击登录按钮后跳转到home页面
     */
    @RequestMapping("/tohome")
    public String tohome(){

        return "/home";
    }

    /**
     * 点击注册按钮跳转到注册页面
     */
    @RequestMapping("/toregister")
    public String toRegister(){

        return "register";
    }


    /**
     * 点击注册按钮跳转到注册页面
     */
    @RequestMapping("/setuser")
    public String setUser(){

        return "/home";
    }

    @RequestMapping("/tomessage")
    public String toMessage(){

        return "message";
    }


    @RequestMapping("/touser")
    public String toUser(){

        return "user";
    }

    @RequestMapping("/touserwant")
    public String toUserWant(){

        return "userwant";
    }


}
