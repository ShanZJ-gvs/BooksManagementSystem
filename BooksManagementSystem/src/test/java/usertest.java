import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.User;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.service.UserWantServiceImpl;
import com.gvssimux.util.GetUUID;
import com.gvssimux.util.JsonUtil;
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
     * 查找一个用户2
     */
    @Test
    public void get2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl user = context.getBean("UserServiceImpl", UserServiceImpl.class);

        System.out.println(user.selectByUserId("e046980119a74101aa358a4326ae57fb"));
    }


    /**
     * 查找全部用户
     */
    @Test
    public void getAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl user = context.getBean("UserServiceImpl", UserServiceImpl.class);

        System.out.println(user.selectAll());
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


    /**
     * 查找userwant
     */
    @Test
    public void get4() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserWantServiceImpl user = context.getBean("UserWantServiceImpl", UserWantServiceImpl.class);

        JsonUtil jsonUtil = new JsonUtil();
        final String s = JSON.toJSON(user.getAll()).toString();
        final String json = jsonUtil.getJson(user.getAll());
        System.out.println(json);
    }

}
