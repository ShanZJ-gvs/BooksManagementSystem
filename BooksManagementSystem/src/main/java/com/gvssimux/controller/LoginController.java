package com.gvssimux.controller;

import com.gvssimux.pojo.User;
import com.gvssimux.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/checkUserPwd")
    public String loginUser(HttpSession session, String username, String pwd) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        User user = mapper.getUserIdByUserNamePwd(username, pwd);
        System.out.println("执行成功=====》:"+user);


        if (user!=null) {
            //把用户的信息存在session中,用于验证
            session.setAttribute("uuid",user);
            System.out.println("LoginController===>");
            return "UserPwdOK";
        }
        return "UserPwdError";

    }

    /**2021
     * 注册----验证用户名是否存在
     */
    @ResponseBody
    @RequestMapping("registerUser/")
    public  int  registerUser (String user) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        //a为1则重复 若a为0不重复
        int a = mapper.getUserByUser(user);
        System.out.println("执行成功=====》:"+user);

        System.out.println(a);

        return a;
    }

    @Test
    public void  test(){
        registerUser("admin");
    }


}
