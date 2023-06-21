package com.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{

    @Override
    public void update() {
        System.out.println("dao.update....");
    }
}
