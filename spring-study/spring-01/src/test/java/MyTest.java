import com.zhehao.dao.UserDao;
import com.zhehao.dao.UserDaoMysqlImpl;
import com.zhehao.dao.UserDaoOracleImpl;
import com.zhehao.pojo.Hello;
import com.zhehao.pojo.MyClass;
import com.zhehao.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testHello() {
        // ClassPathXmlApplicationContext是ApplicationContext接口的一个实现，从类路径加载xml配置文件
        // ApplicationContext是一个Spring容器，不再需要实例化对象，将创建对象的创建管理由程序代码反转到了Spring容器，即控制反转（Inversion of Control）
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 获取id为hello的bean，Hello对象由Spring框架创建，对象信息在xml中配置，并注入到hello变量中（Dependency Injection）
        Hello hello = (Hello) context.getBean("hello");

        System.out.println(hello);
    }

    @Test
    public void testUser() {
//        UserServiceImpl userService = new UserServiceImpl(new UserDaoMysqlImpl());
//        userService.getUserDao().hello();
//
//        userService = new UserServiceImpl(new UserDaoOracleImpl());
//        userService.getUserDao().hello();

        // 不再需要手动创建对象，直接让spring注入
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userService = (UserServiceImpl) context.getBean("userService");
        userService.getUserDao().hello();
    }

    @Test
    public void testMyClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyClass myClass = (MyClass) context.getBean("myClass");
        System.out.println(myClass);
    }
}
