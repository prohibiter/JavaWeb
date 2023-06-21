package com.example.servlettest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo6")
public class ServletDemo6 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo6");

        req.setAttribute("msg", "from demo6");
        //请求转发
        /*
        1、浏览器地址栏没发生变化
        2、只能访问当前的服务器内部资源中
        3、转发是一次请求
         */
        req.getRequestDispatcher("/demo7").forward(req, resp);
        Object msg = req.getAttribute("msg");
        System.out.println(msg);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
