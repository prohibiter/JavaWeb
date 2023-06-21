package com.SpringMVC.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ExceptionController {

//    @RequestMapping("/math")
//    public String math(){
//        int i = 10/0;
//        return "success";
//    }

    //value中存储可能出现的所有异常
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String testException(Exception e, Model model){
        model.addAttribute("ex",e);
        return "error";
    }

}
