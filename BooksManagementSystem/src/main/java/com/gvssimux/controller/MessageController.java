package com.gvssimux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

    @RequestMapping("/tomessage")
    public String toBorrow(){

        return "message";
    }
}
