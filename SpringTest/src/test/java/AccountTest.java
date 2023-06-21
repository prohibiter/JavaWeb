import com.spring.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void accountTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Account.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }
}
