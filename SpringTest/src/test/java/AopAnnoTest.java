import com.spring.aopanno.User;
import com.spring.aopanno.UserProxy;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAnnoTest {

    @Test
    public void aopAnnoTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aopanno.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
