package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/index")
    public String index(){
        return "interceptor/index";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){

        return "success";
    }

}
