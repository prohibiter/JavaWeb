package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    //创建UserDao类型的属性，生成set方法
    @Autowired
    private UserDaoImpl udi;

    public void add(){
        System.out.println("user.add...");

        udi.update();

    }

}
