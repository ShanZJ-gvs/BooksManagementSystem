package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageJumpController {

    /**
     * 跳转页面
     */
    @RequestMapping("/tobookinf")
    public String toBookInf(Model model) throws JsonProcessingException {

        return "bookinf";
    }


    @RequestMapping("/toborrow")
    public String toBorrow() throws JsonProcessingException{

        return "borrow";
    }



    /**
     * 点击登录按钮后跳转到home页面
     */
    @RequestMapping("/tohome")
    public String tohome()throws JsonProcessingException{

        return "/home";
    }

    /**
     * 点击注册按钮跳转到注册页面
     */
    @RequestMapping("/toregister")
    public String toRegister()throws JsonProcessingException{

        return "register";
    }




    @RequestMapping("/tomessage")
    public String toMessage()throws JsonProcessingException{

        return "message";
    }


    @RequestMapping("/touser")
    public String toUser()throws JsonProcessingException{

        return "user";
    }

    @RequestMapping("/touserwant")
    public String toUserWant()throws JsonProcessingException{

        return "userwant";
    }


}
