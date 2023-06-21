package test.java;

import com.spring.collectiontype.Stu;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StuTest {
    @Test
    public void stuTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resource/StuBean.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu.toString());
    }
}
