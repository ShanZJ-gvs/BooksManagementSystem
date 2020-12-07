import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.Borrow;
import com.gvssimux.pojo.User;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.BorrowServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.GetUUID;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

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
}
