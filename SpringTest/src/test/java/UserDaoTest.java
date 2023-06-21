package test.java;

import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {

    @Test
    public void userDaoTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resource/UserBean.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }
}
