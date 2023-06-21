package com.SpringMVC.controller;

import com.SpringMVC.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamsController {
    @RequestMapping("/testServletAPI")
    //形参表示当前请求，由控制器帮忙注入
    public String testServletAPI(HttpServletRequest request) {
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        return "test_params";
    }

    @RequestMapping("/testParam")
    //只要形参名与传递的参数名一致就可以获得参数
    public String TestParam(
            //required表示该值是否可以为空，defaultValue表示该值为空时，系统默认的值为多少
            @RequestParam(value = "username", required = false, defaultValue = "username") String username,
            @RequestParam("password") String password,
            @RequestParam("hobby") String hobby,
            //获取请求头信息
            @RequestHeader("Host") String host,
            @CookieValue("JSESSIONID") String sessionId) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(hobby);
        System.out.println(host);
        return "test_params";
    }

    //通过实体类获取对象
    @RequestMapping("/testBean")
    public String testBean(User user) {
        System.out.println(user);
        return "test_params";
    }
}
