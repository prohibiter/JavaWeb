package com.example.domain;

/*
user的JavaBean
类用public修饰
成员变量使用private修饰
提供空的构造器
提供public getter和setter方法
功能：封装数据

属性：getter和setter方法去除get或set之后再将首字母变为小写，即为属性
使用setProperty和getProperty可以调用getter和setter方法操作数据
 */

public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
