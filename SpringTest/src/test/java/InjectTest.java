import com.spring.autowired.Emp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectTest {

    @Test
    public void injectTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("die.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }
}
