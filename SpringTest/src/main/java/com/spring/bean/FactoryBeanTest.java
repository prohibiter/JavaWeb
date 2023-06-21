package com.spring.bean;

import com.spring.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;


//FactoryBean类的bean的返回值可以与定义的类型不一致
//普通bean必须一致
public class FactoryBeanTest implements FactoryBean<Course> {

    //定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setName("高数");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
