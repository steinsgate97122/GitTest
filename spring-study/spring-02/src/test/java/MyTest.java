import com.zhehao.pojo.Student;
import com.zhehao.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void testDependencyInjection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu = (Student) context.getBean("stu");
        System.out.println(stu);
    }

    @Test
    public void testScope() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // stu的作用域为singleton，两次返回同一个实例
        Student stu1 = context.getBean("stu", Student.class);
        Student stu2 = context.getBean("stu", Student.class);
        Assert.assertSame(stu1, stu2);

        // user的作用域为prototype，每次返回不同实例
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        Assert.assertNotSame(user1, user2);
    }
}
