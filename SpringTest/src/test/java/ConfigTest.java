package test.java;

import com.spring.autowired.Emp;
import com.spring.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {

    @Test
    public void configTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.add();
    }
}
