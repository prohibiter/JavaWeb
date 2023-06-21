package com.SpringMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/index")
    public String userIndex(){
        return "userIndex";
    }

    /*
        使用RESTFul模拟用户资源的增删改查
        /user/operation  GET  查询所有用户信息
        /user/operation/1   GET  根据用户ID查询信息
        /user/operation  POST  添加用户信息
        /user/operation/1  DELETE  删除用户信息
        /user/operation   PUT  修改用户信息
     */
    @RequestMapping(value = "/operation", method = RequestMethod.GET)
    public String getAllUser(){
        String sql = "select * from user";
        Map<String, Object> res = jdbcTemplate.queryForMap(sql);
        Iterator iterator = res.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/operation/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") int id){
        String sql = "select * from user where id=?";
        Map<String, Object> res = jdbcTemplate.queryForMap(sql,id);
        Iterator iterator = res.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("查询指定用户信息");
        return "success";
    }

    @RequestMapping(value = "/operation", method = RequestMethod.POST)
    public String addUser(int id,String username){
        String sql = "insert into user value(?,?)";
        int update = jdbcTemplate.update(sql,id,username);
        System.out.println(update);
        System.out.println("添加用户信息");
        return "success";
    }

    @RequestMapping(value = "/operation",method = RequestMethod.PUT)
    public String updateUser(int id,String username){
        String sql = "update user set username=? where id=?";
        int update = jdbcTemplate.update(sql, username, id);
        System.out.println("修改用户信息");
        return "success";
    }

    @RequestMapping(value = "/operation/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete * from user where id=1";
        jdbcTemplate.execute(sql);
        System.out.println("删除用户信息");
        return "success";
    }
}
