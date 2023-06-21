package com.example.servlettest;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
注解
urlPattern：url地址，可以定义多个地址（1、/xxx  2、/xxx/xxx  3、 *.xxx）
 */
@WebServlet(urlPatterns = "/demo3",description = "demo3",displayName = "demo3")
public class ServletDemo3 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("demo3.webservlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
