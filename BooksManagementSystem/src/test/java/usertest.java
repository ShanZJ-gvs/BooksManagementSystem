import com.gvssimux.pojo.User;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.GetUUID;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class usertest {


    /**
     * 查找一个用户
     */
    @Test
    public void get(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl user = context.getBean("UserServiceImpl", UserServiceImpl.class);

        System.out.println(user.selectByPrimaryKey(1));
    }


    /**
     * 修改
     */
    @Test
    public void set(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl user = context.getBean("UserServiceImpl", UserServiceImpl.class);

        User user1 = new User(2,GetUUID.get());
        System.out.println(user.updateByPrimaryKeySelective(user1));
    }



    /**
     * 增加
     */
    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl user = context.getBean("UserServiceImpl", UserServiceImpl.class);

        User user1 = new User("小明",GetUUID.get(),"user01","12345","user",5);
        System.out.println(user.insertSelective(user1));
    }


    /**
     * 删除
     */
    @Test
    public void drop(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl user = context.getBean("UserServiceImpl", UserServiceImpl.class);

        System.out.println(user.deleteByPrimaryKey(2));
    }

}
