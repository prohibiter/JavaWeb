package com.spring.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component(value = "userProxy")
@Aspect
public class UserProxy {

    @Pointcut(value = "execution(void com.spring.aopanno.User.add())")
    public void pointCut(){}

    //方法执行前
    @Before(value = "pointCut()")
    public void before(){
        System.out.println("before...");
    }

    //方法执行后
    @After(value = "pointCut()")
    public void after(){
        System.out.println("after...");
    }

    //return之后
    @AfterReturning(value = "execution(void com.spring.aopanno.User.add())")
    public void afterReturning(){
        System.out.println("afterReturning...");
    }

    //抛出异常之后
    @AfterThrowing(value = "execution(void com.spring.aopanno.User.add())")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }

    //方法执行前后都会执行
    @Around(value = "execution(void com.spring.aopanno.User.add())")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //环绕前
        System.out.println("beforeAround...");
        //被增强的方法
        proceedingJoinPoint.proceed();
        //环绕后
        System.out.println("afterAround...");
    }
}
