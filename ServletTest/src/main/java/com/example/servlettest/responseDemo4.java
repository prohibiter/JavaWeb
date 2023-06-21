package com.example.servlettest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class responseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //设置编码方式
//        resp.setCharacterEncoding("utf-8");
//        //告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用改编码解码
//        resp.setHeader("content-type","txt/html;charset=utf-8");
        //简单方式设置
        resp.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter writer = resp.getWriter();
        //输出数据
        writer.write("你好 response");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
