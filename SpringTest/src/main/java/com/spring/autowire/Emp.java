package com.spring.autowire;

public class Emp {
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
