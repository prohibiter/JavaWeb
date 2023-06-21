package test.java;

import com.spring.autowire.Emp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptTest {
    @Test
    public void deptTest(){
        ClassPathXmlApplicationContext deptBean = new ClassPathXmlApplicationContext("resource/DeptBean.xml");
//        Emp emp = deptBean.getBean("emp", Emp.class);
//        System.out.println(emp.toString());
    }

    @Test
    public void autoWireTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resource/AutoWireBean.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);

    }
}
