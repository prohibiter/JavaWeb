package com.example.servlet;

import com.example.domain.User;
import com.example.dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/userLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        User loginUser = new User();
//        loginUser.setUsername(req.getParameter("username"));
//        loginUser.setPassword(req.getParameter("password"));
        User loginUser = null;

        try {
            //获取请求参数
            Map<String, String[]> pm = req.getParameterMap();
            loginUser = new User();
            BeanUtils.populate(loginUser,pm);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserDao ud = new UserDao();
        User user = ud.login(loginUser);
        if(user == null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else{
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }

        /*
        重定向
        地址栏发生变化      不发生变化
        可以访问其他站点的资源    转发只能转发当前服务器下的资源
        重定向是两次请求（不能用req.setAttribute共享数据）       转发是一次请求
         */
//        resp.setStatus(302);
//        resp.setHeader("location" ,"/successServlet");

        //简单重定向
        //获取虚拟目录
//        String contextPath = req.getContextPath();
//        resp.sendRedirect(contextPath + "/successServlet");


    }
}
