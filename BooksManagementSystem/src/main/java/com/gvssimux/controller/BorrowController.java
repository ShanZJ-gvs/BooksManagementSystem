package com.gvssimux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BorrowController {

    /**
     * 根据id查询
     */
    @RequestMapping("/toborrow")
    public String toBorrow(){

        return "borrow";
    }
}
