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
        BookInf Inf = new BookInf("伊卡狛格",
                "[英] J·K·罗琳",
                "人民文学出版社",
                "编程",
                "一个最为幸福富饶的国度，究竟潜藏着怎样的怪兽和阴谋？\n" +
                        "\n" +
                        "----------------------------------------------------------------------------------\n" +
                        "\n" +
                        "从前，有一个叫做丰饶角的小国家，那里的人们生活富足而幸福。丰饶角的美食声名远播，从美酪城的奶油干酪到甘蓝城的“天堂的希望”，每一种都足以让食客在品尝时冒出喜悦的泪花。\n" +
                        "\n" +
                        "不过，即使是在如此幸福的国度里，也有怪物暗藏。传说在沼泽乡的最北边，住着一头可怕的怪物——伊卡狛格。有人说它会喷火，会吐毒液，还会在浓雾中咆哮着拖走不听话的绵羊和小孩。也有人说，伊卡狛格不过是传说罢了……\n" +
                        "\n" +
                        "后来这个传说发展得越发不受控制，为整个国度都蒙上了一层阴霾，这时，两个小孩——一对最要好的朋友，伯特和黛西——开始了他们的伟大征程，决心要揪出真相，探寻怪物的真正巢穴，将希望和幸福重新带回丰饶角。\n" +
                        "\n" +
                        "如果你足够勇敢，就翻开这本书，阅读这个全新的精彩故事吧。这个故事有关真相、希望和友谊，它们的力量足以克服一切。",
                "9787020166916", "59.00",3,3);
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


    /**
     * 全部查询
     */
    @Test
    public void getAllBook(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);

        System.out.println("执行成功=====》:"+bookInfServiceImpl.selectAll());
    }








}
