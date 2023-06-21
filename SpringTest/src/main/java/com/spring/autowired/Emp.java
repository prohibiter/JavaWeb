package com.spring.autowired;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value = "emp")
public class Emp {
    @Autowired
    @Qualifier("dept")
    Dept dept;

    public void add() {
        System.out.println("emp.add...");
        dept.add();
    }
}
