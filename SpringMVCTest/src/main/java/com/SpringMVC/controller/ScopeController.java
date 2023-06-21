package com.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/*@Controller
@RequestMapping("/scope")*/
@RestController("/scope")
public class ScopeController {

    @RequestMapping("/index")
    public String scope(){
        return "scope";
    }

    @RequestMapping("/testRequestByServletAPI")
    public String byServletAPI(HttpServletRequest request){
        request.setAttribute("index",1);
        return "getByServletAPI";
    }

    @RequestMapping("/getByServletAPI")
    public String getByServletAPI(HttpServletRequest request){
        System.out.println(request.getAttribute("index"));
        return "scope";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mav.addObject("index","mavIndexxxx");
        //设置视图名称，相当于之前的返回字符串中的视图名
        mav.setViewName("getByServletAPI");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("index","modelIndex");
        return "getByServletAPI";
    }

    @RequestMapping("/testMap")
    //通过map集合向request添加param
    public String testMap(Map<String,Object> map){
        map.put("index","mapIndex");
        return "getByServletAPI";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("index","ModelMapIndex");
        return "getByServletAPI";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession httpSession){
        httpSession.setAttribute("index","session");
        return "getByServletAPI";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession request){
        ServletContext context = request.getServletContext();
        context.setAttribute("index","application");
        return "getByServletAPI";
    }
}
