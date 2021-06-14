import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.User;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.BorrowServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

public class registerTest {



    /**2021
     * 注册----验证用户名是否存在
     */
    @Test
    public void registerUser1 (String user) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        user = "admin";
        int U = mapper.getUserByUser(user);
        System.out.println("执行成功=====》:"+user);

        System.out.println(U);

    }

}
