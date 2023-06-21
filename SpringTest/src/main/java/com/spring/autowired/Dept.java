package com.spring.autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository(value = "dept")
public class Dept {
    public void add(){
        System.out.println("dept.add....");
    }
}
