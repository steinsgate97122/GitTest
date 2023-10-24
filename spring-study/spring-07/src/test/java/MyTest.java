import com.zhehao.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testAOP() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.saveUser();
    }

    @Test
    public void testAOP2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.saveUser();
    }

    @Test
    public void testAOP3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.saveUser();
    }
}
