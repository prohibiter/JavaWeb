package test.java;

import com.spring.collectiontype.Course;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {

    @Test
    public void factoryTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resource/factory.xml");
        Course factory = context.getBean("factory", Course.class);
        System.out.println(factory);
    }
}
