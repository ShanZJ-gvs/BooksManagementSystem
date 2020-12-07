import com.gvssimux.pojo.BookInf;
import com.gvssimux.service.BookInfService;
import com.gvssimux.service.BookInfServiceImpl;
import jdk.nashorn.internal.ir.debug.ClassHistogramElement;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;


public class test {


    /**
     * 增加
     */
    @Test
    public void addBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        BookInf Inf = new BookInf("深入了解JAVA虚拟机",
                "周志明",
                "机械工业出版社",
                "编程",
                "内容介绍\n" +
                "\n" +
                "这是一部从工作原理和工程实践两个维度深入剖析JVM的著作，是计算机领域公认的经典，繁体版在台湾也颇受欢迎。\n" +
                "\n" +
                "自2011年上市以来，前两个版本累计印刷36次，销量超过30万册，两家主要网络书店的评论近90000条，内容上近乎零差评，是原创计算机图书领域不可逾越的丰碑。\n" +
                "\n" +
                "第3版在第2版的基础上做了重大修订，内容更丰富、实战性更强：根据新版JDK对内容进行了全方位的修订和升级，围绕新技术和生产实践新增逾10万字，包含近50%的全新内容，并对第2版中含糊、瑕疵和错误内容进行了修正。\n",
                "978-7-111-64124-7", "129.00",5,2);
        bookInfServiceImpl.insertSelective(Inf);
    }


    /**
     * 删除
     */
    @Test
    public void deleteBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);


        System.out.println("执行成功deleteBook=====》:"+bookInfServiceImpl.deleteByPrimaryKey(3));
    }


    /**
     * 根据id去部分修改
     */
    @Test
    public void setBookById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        BookInf Inf = new BookInf(6,5);
        System.out.println("执行成功setBookById=====》:"+bookInfServiceImpl.updateByPrimaryKeySelective(Inf));
    }



    /**
     * 根据id查询
     */
    @Test
    public void getBookById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        System.out.println("执行成功=====》:"+bookInfServiceImpl.selectByPrimaryKey(6));
    }








}
