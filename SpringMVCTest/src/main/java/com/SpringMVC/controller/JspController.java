package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
