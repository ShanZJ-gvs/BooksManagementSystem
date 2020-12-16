package com.gvssimux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserWantController {
    @RequestMapping("/touserwant")
    public String toBorrow(){

        return "userwant";
    }

}
