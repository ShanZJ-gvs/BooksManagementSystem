package com.gvssimux.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    /**
     * 点击登录按钮后跳转到home页面
     */
    @RequestMapping("/tohome")
    public String tohome(){

        return "/home.jsp";
    }
    /**
     * 点击注册按钮跳转到注册页面
     */
    @RequestMapping("/register")
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



    @ResponseBody
    @RequestMapping("/check")
    public String loginUser(String name,String pwd) {

        String msg = "";

        if (name != null) {
            //admin 这里是从数据库查询，在这里先写死
            if ("admin".equals(name)) {
                msg = "UserNameOK";
            }else {
                msg = "UserNameError";
            }

        }

        if (pwd != null) {
            //admin 这里是从数据库查询，在这里先写死
            if ("12345".equals(pwd)) {
                msg = "UserPwdOK";
            }else {
                msg = "UserPwdError";
            }

        }
        return msg;

    }

}
