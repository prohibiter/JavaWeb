package com.example.servlettest;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/*
http默认get
 */
@WebServlet("/demo5")
public class ServletDemo5 extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        /*
//        //获取请求头数据
//        String[] info = new String[8];
//        //获取请求方法
//        info[0] = req.getMethod();
//        //获取虚拟目录
//        info[1] = req.getContextPath();
//        //获取Servlet路径
//        info[2] = req.getServletPath();
//        //获取get方式请求参数
//        info[3] = req.getQueryString();
//        //获取请求URI
//        info[4] = req.getRequestURI();
//        info[5] = req.getRequestURL().toString();
//        //获取协议及版本
//        info[6] = req.getProtocol();
//        //获取客户机的IP地址
//        info[7] = req.getRemoteAddr();
//
//        for (int i = 0; i < 8; i++) {
//            System.out.println(info[i]);
//        }
//        Enumeration<String> es = req.getHeaderNames();
//        while(es.hasMoreElements()){
//            System.out.println(req.getHeader(es.nextElement()));
//        }
//        //获取请求行数据
//        String agent = req.getHeader("user-agent");
//        if(agent.contains("Chrome")){
//            System.out.println("谷歌浏览器");
//        }
//        if(agent.contains("firefox")){
//            System.out.println("火狐浏览器");
//        }
//        if(agent.contains("Edg")){
//            System.out.println("edge浏览器");
//        }
//        //获取请求体数据，只有post请求才有请求体
//        ServletInputStream inputStream = req.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        char[] s = new char[1024];
//        int len;
//        while((len = inputStreamReader.read(s)) != -1){
//            System.out.println(String.valueOf(s,0,len));
//        }
//        BufferedReader reader = req.getReader();
//        char[] c =new char[1024];
//        int len;
//        while((len = reader.read(c)) != -1){
//            System.out.println(String.valueOf(c,0,len));
//        }
//        BufferedReader reader = req.getReader();
//        char[] c =new char[1024];
//        int len;
//        while((len = reader.read(c)) != -1){
//            System.out.println(String.valueOf(c,0,len));
//        }
//         */
//
//        String method = req.getMethod();
//        if(method == "POST"){
//            this.doPost(req,resp);
//        }else if(method == "GET"){
//            this.doGet(req,resp);
//        }
//
//    }

    //提交get请求的时候执行代码
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
    }

    //提交post请求的时候执行代码
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //将编码格式修改为页面的编码格式，解决参数中文乱码问题
        req.setCharacterEncoding("UTF-8");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        System.out.println("username:" + username + ",password:" + password);
//        String[] hobbies = req.getParameterValues("hobby");
//        for (String hobby :
//                hobbies) {
//            System.out.println(hobby);
//        }


//        Enumeration<String> parameterNames = req.getParameterNames();
//        while(parameterNames.hasMoreElements()){
//            String parameterName = parameterNames.nextElement();
//            System.out.println(parameterName + ":" + req.getParameter(parameterName));
//        }
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, String[]> next = iterator.next();
//            System.out.println(next.getKey());
//            for (String value :
//                    next.getValue()) {
//                System.out.println(value);
//            }
//        }
    }
}
