package com.example.servlettest;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.utils.Druid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc::mysql:/localhost:3360/jdbc","root","root");
//            String sql = "select * from login where username = ? and password = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,req.getParameter("username"));
//            preparedStatement.setString(2,req.getParameter("password"));
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            if(resultSet != null){
//               System.out.println("登录成功");
//            }else{
//                System.out.println("登录失败");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = Druid.getConnection();
            String sql = "select * from login where usernmae = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,req.getParameter("username"));
            ps.setString(2,req.getParameter("password"));
            rs = ps.executeQuery();
            rs.next();
            if(rs != null){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                Druid.close(rs,ps,conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

