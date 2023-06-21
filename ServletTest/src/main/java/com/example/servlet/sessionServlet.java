package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionServlet")
public class sessionServlet extends HttpServlet {
    //服务器端会话技术，session在一次会话的多次请求中共享数据，将数据保存在服务器的对象中
    //session是基于cookie实现的，cookie中存放着session的ID，每次servlet创建的session都是基于这一ID创建

    /*
    特点
     */


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("msg","hello");
        //关闭客户端，服务器不关闭，再次获取session，不为同一个
        //若要实现session持久化，可以利用cookie对象
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(1000);
        resp.addCookie(cookie);

        //服务器重启后，session不是同一个，该情况下要保证数据不丢失，tomcat自动实现
        //session钝化：在服务器正常关闭后，将session对象系列化到硬盘上（序列化）
        //session活化：服务器启动后，将session文件转化为内存中的对象（反序列化）
        //活化之后的sessionID不一样，只能保证数据不变

        //session销毁
        //服务器关闭
        //session对象调用invalidate()
        //session默认30分钟失效
        //..\apache-tomcat-9.0.54\conf\web.xml文件中的session标签可以设置失效时间
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
