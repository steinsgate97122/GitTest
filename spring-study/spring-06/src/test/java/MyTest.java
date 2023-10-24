import com.zhehao.service.ProxyInvocationHandler;
import com.zhehao.service.UserService;
import com.zhehao.service.UserServiceImpl;
import com.zhehao.service.UserServiceProxy;
import org.junit.Test;

public class MyTest {
    @Test
    public void testClient() {
        UserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserService(userService);
        // 业务侧实际调用代理类
        userServiceProxy.saveUser();
    }

    @Test
    public void testDynamicProxy() {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setTarget(userService);
        UserService proxy = (UserService) handler.getProxy();
        proxy.saveUser();
    }
}
