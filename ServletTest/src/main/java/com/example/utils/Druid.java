package com.example.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.servlettest.LoginServlet;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/*
JDBC工具类，使用druid
 */
public class Druid {
    private static DataSource ds;

    //获取连接池
    static {
        try {
            //加载配置文件
            Properties prop = new Properties();
            InputStream is = Druid.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(is);
            //获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取链接
    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }

    //关闭链接
    public static void close(Statement state, Connection conn) throws Exception {
        close(null, state, conn);
    }

    //关闭链接
    public static void close(ResultSet rs, Statement state, Connection conn) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (state != null) {
            state.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    //获取链接池
    public static DataSource getDs() {
        return ds;
    }
}
