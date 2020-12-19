import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.Borrow;
import com.gvssimux.pojo.User;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.BorrowServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.GetUUID;
import com.gvssimux.util.JsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class borrow {


    /**
     * 增加借阅记录*/
    @Test
    public void add(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl borrowmapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);
        UserServiceImpl usermapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        System.out.println("执行成功=====》:"+bookInfServiceImpl.selectByPrimaryKey(6));

        User user = usermapper.selectByPrimaryKey(1);
        BookInf bookInf = bookInfServiceImpl.selectByPrimaryKey(6);
        Borrow borrow = new Borrow(GetUUID.get(), user.getUserid(), bookInf.getBookName(), bookInf.getIsbn(),
                "待借出", new Date(), null, null, null);

        borrowmapper.insertSelective(borrow);

    }


    /**
     * 全部查询
     */
    @Test
    public void getAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);

        System.out.println("执行成功=====》:"+mapper.selectAll());
    }


    /**
     * 两表查询
     */
    @Test
    public void get2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);

        System.out.println("执行成功=====》:"+mapper.selectAll());
    }


    /**
     * 三表查询
     */
    @Test
    public void get3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);

        System.out.println("执行成功=====》:"+mapper.get3Table());
    }

    @Test
    public void get10() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);
        BorrowServiceImpl mapper2 = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);
        BookInfServiceImpl mapper3 = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        Date date = new Date();
        //int[] ints = {mapper3.getBookNum(), mapper.getUserNum(), mapper2.getBorrowNum(),mapper2.getOverNum(date)};
        JsonUtil jsonUtil = new JsonUtil();
        //System.out.println(jsonUtil.getJson(ints));
        System.out.println(jsonUtil.getJson(mapper2.getOverNum(date)));

    }



    /**
     * 查询每月的借阅总数
     */
    @Test
    public void get4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BorrowServiceImpl mapper = context.getBean("BorrowServiceImpl", BorrowServiceImpl.class);

        int[] ints = new int[12];
        for (int i = 0; i < 12; i++) {
            int j = i +1;
            ints[i] = mapper.getPerSum("%-"+j+"-%");
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.println("数组==》"+ ints[i]);
        }

        System.out.println("执行成功=====》:"+mapper.getPerSum("%-11-%"));
    }



}
