package com.SpringMVC.controller;

import com.SpringMVC.bean.Uuser;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;

@Controller
@RequestMapping("/request")
public class HttpController {

    @RequestMapping("/index")
    public String index() {
        return "requestBody";
    }

    @RequestMapping("/requestBody")
    public String getParam(@RequestBody String request) throws Exception {
        System.out.println(URLDecoder.decode(request, "Utf-8"));
        return "success";
    }

    @RequestMapping("/getEntity")
    public String getEntity(RequestEntity<String> entity) {
        System.out.println(entity.getHeaders());
        System.out.println(entity.getBody());
        return "success";
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "testResponseBodySuccess";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public Uuser getUser() {
        return new Uuser();
    }
}
