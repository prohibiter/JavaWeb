package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    //ThymeleafView，不带任何前缀时的视图，此时才会被thymeleaf解析器解析
    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(){
        return "success";
    }

    //转发：InternalResourceView视图，地址栏不发生改变
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/view/testThymeleaf";
    }

    //重定向：RedirectView视图，地址栏发生改变，变为重定向之后的地址
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/view/testThymeleaf";
    }


}
