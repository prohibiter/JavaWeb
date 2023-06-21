package com.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextServlet")
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        ServletContext对象获取
         */

        ServletContext reqsc = req.getServletContext();
//        ServletContext httpsc = super.getServletContext();
//        System.out.println(reqsc);
//        System.out.println(httpsc);

        /*
                获取MIME类型
                MIME是在互联网通信过程中定义的一种文件数据类型
                大类型/小类型
                image/jpeg
         */
        String fileName = "a.jpg";
        String mimeType = reqsc.getMimeType(fileName);
        System.out.println(mimeType);

        /*
        域对象：共享数据
        setAttribute()
        getAttribute()
        removeAttribute()
        ServletContext对象范围：所有用户所有请求的数据

         */
    }
}
