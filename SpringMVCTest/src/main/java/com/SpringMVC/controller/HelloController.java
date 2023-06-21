package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/index",
            method = {RequestMethod.GET, RequestMethod.POST}
            /*
            1、一定要有username属性
            2、一定不能有password属性
            3、index属性要为123
            4、page属性一定不能等于456
             */
            //params = {"username", "!password", "index=123", "page!=456"}
    )
    public String index() {
        return "index1";
    }

    @RequestMapping("/target")
    public String target() {
        return "target";
    }

    @RequestMapping("/test/{id}")
    public String test(@PathVariable("id")Integer id){
        System.out.println(id);
        return "target";
    }

    @RequestMapping("/param")
    public String getParam(){
        return "test_params";
    }

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }

    @RequestMapping("/math")
    public String testMath(){
        int i = 1/0;
        return "success";
    }

}
