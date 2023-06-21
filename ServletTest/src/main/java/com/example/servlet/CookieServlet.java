package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        cookie特点
        1、cookie存储数据在客户端浏览器
        2、浏览器对于单个cookie的大小有限制（4kb）以及对同一个域名下的总cookie数量也有限制

        作用
        1、cookie一般用于存储少量的不太敏感的数据
        2、在不登陆的情况下，完成服务器对客户端的身份识别
         */


        //设置cookie，只有单浏览器中有效，跨浏览器无效，关闭浏览器，cookie清空
        Cookie cookie = new Cookie("msg","hello");
        /*
        设置coolie的生命周期，持久化存储
        正数：将cookie存到硬盘的文件中，数字为存在时间
        负数：默认值
        零：删除cookie信息
         */
        cookie.setMaxAge(1000);
        resp.addCookie(cookie);

        //设置cookie的获取范围，默认情况下，设置当前额虚拟目录
        //共享需要设置为“/”
        cookie.setPath("/");
        /*
        setDomain(String Path)：设置一级域名相同，那么多个服务器之间cookie可以共享
        serDomain(".baidu.com");
         */

        //存储中文数据
        Cookie cookie1 = new Cookie("zhmsg","中文");
        resp.addCookie(cookie1);

        /*
        在一个服务器中部署了多个web项目，默认情况下多项目不共享cookie
         */
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
