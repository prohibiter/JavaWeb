package com.spring.aopanno;

import org.springframework.stereotype.Component;

@Component(value = "user")
public class User {
    public void add(){
        System.out.println("add...");
    }
}
