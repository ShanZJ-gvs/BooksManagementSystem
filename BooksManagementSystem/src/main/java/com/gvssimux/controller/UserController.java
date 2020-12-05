package com.gvssimux.controller;



import com.gvssimux.pojo.User;
import com.gvssimux.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @RequestMapping("/login")
    public User login(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);

        return mapper.selectByPrimaryKey(1);
    }
    @RequestMapping("/gvs")
    public String login23(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);

        model.addAttribute("msg","springmvc注解");

        return "gvs1";
    }

}
