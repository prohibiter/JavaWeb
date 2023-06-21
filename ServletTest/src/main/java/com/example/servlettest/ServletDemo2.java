package com.example.servlettest;

import javax.servlet.*;
import java.io.IOException;

/*
servlet生命周期：
被创建：执行init方法，只执行一次
提供服务：执行service方法
被销毁：执行destroy
 */
public class ServletDemo2 implements Servlet {

    /*
    servlet被创建时执行，只会执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    /*
    获取servletcnfig对象
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
    每次servlet调用时都会执行，执行很多次
    在service中定义局部变量，不要在类中定义成员变量，以解决线程安全问题
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service......");
    }

    /*
    获取servlet的信息，版本，作者。。。
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /*
    在服务器正常关闭时执行，执行一次。
     */
    @Override
    public void destroy() {
        System.out.println("destroy.....");
    }
}
