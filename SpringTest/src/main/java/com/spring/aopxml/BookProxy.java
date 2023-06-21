package com.spring.aopxml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component(value = "bookProxy")
@Aspect
public class BookProxy {

    @Before(value = "execution(* com.spring.aopxml.Book.buy())")
    public void before(){
        System.out.println("before...");
    }
}
