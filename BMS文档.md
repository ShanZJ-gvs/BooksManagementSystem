# 系统具体功能

## 系统功能图

1. 图书库

    显示全部图书、查询图书、编辑图书

2. 历史借阅

    查询借阅的信息

3. 用户管理

    增加、删除、查询、修改

4. 消息处理

    处理借书申请、处理归还申请、处理逾期申请

5. 增库申请

    处理用户想要增加的图书





## 技术栈

JDK1.8、SQL、HTML、CSS、JavaScript、Mysql5.7、Tomcat9、Maven

前端框架：Jquery、Bootstarp4.3、ChartJS

后端框架：Spring5、SpringMVC、Mybatis

工具：Lombok、Jackson、Junit、UUID

日志：Log4j

数据库连接：c3p0





# 代码分析(以BookInf为例)

此图书管理系统我们采取了前后端分离的设计，主要用于后端给前端传输Jason字符串，前端会对此进行解析，并在页面显示解析后的结果。前端所使用到的是前端三元件：Html、Css、Js，后端使用到了Spring和SpringMVC、MyBatis框架。

## 代码目录（后端）

![image-20210104152836216](image\image-20210104152836216.png)

三层架构，Dao层编操作数据库，Service层写业务，Controller层与前端交互

### DAO层

![image-20210104153010670](image\image-20210104153010670.png)

每个数据库对应一个操作接口，使用到了Mybatis框架，并且同时使用了注解和xml两种形式

BookInfDao.java

```java
package com.gvssimux.dao;

import com.gvssimux.pojo.BookInf;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookInfDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BookInf record);

    int insertSelective(BookInf record);

    BookInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookInf record);

    int updateByPrimaryKey(BookInf record);

    @Select("select * from bookinf")
    List<BookInf> selectAll();

    //根据ISBN查询图书信息
    @Select("select * from bookinf where ISBN = #{isbn}")
    BookInf getBookByIsbn(String isbn);

    //查询书库数量
    @Select("SELECT COUNT(*) FROM `bookinf`")
    int getBookNum();

    //查询书库剩余数量
    @Select("SELECT SUM(bookinf.num) FROM bookinf")
    int getBookHave();

    //模糊查询（未写完）
    List<BookInf> searchBook(BookInf record);

}
```

BookInfDao.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.gvssimux.dao.BookInfDao">
  <resultMap id="BaseResultMap" type="com.gvssimux.pojo.BookInf">
    <id column="id" jdbcType="INTEGER" property="id" />
    <result column="book_name" jdbcType="VARCHAR" property="bookName" />
    <result column="book_author" jdbcType="VARCHAR" property="bookAuthor" />
    <result column="book_publish" jdbcType="VARCHAR" property="bookPublish" />
    <result column="book_type" jdbcType="VARCHAR" property="bookType" />
    <result column="book_introduction" jdbcType="VARCHAR" property="bookIntroduction" />
    <result column="ISBN" jdbcType="VARCHAR" property="isbn" />
    <result column="money" jdbcType="VARCHAR" property="money" />
    <result column="sum" jdbcType="INTEGER" property="sum" />
    <result column="num" jdbcType="INTEGER" property="num" />
  </resultMap>
  <!--在当前Mapper.xml中使用二级缓存-->
  <cache  eviction="FIFO"
          flushInterval="60000"
          size="512"
          readOnly="true"/>
  <sql id="Base_Column_List">
    id, book_name, book_author, book_publish, book_type, book_introduction, ISBN, money, 
    `sum`, num
  </sql>
  <select id="selectByPrimaryKey" parameterType="java.lang.Integer" resultMap="BaseResultMap">
    select 
    <include refid="Base_Column_List" />
    from bookinf
    where id = #{id,jdbcType=INTEGER}
  </select>
  <delete id="deleteByPrimaryKey" parameterType="java.lang.Integer">
    delete from bookinf
    where id = #{id,jdbcType=INTEGER}
  </delete>
  <insert id="insert" keyColumn="id" keyProperty="id" parameterType="com.gvssimux.pojo.BookInf" useGeneratedKeys="true">
    insert into bookinf (book_name, book_author, book_publish, 
      book_type, book_introduction, ISBN, 
      money, `sum`, num)
    values (#{bookName,jdbcType=VARCHAR}, #{bookAuthor,jdbcType=VARCHAR}, #{bookPublish,jdbcType=VARCHAR}, 
      #{bookType,jdbcType=VARCHAR}, #{bookIntroduction,jdbcType=VARCHAR}, #{isbn,jdbcType=VARCHAR}, 
      #{money,jdbcType=VARCHAR}, #{sum,jdbcType=INTEGER}, #{num,jdbcType=INTEGER})
  </insert>
  <insert id="insertSelective" keyColumn="id" keyProperty="id" parameterType="com.gvssimux.pojo.BookInf" useGeneratedKeys="true">
    insert into bookinf
    <trim prefix="(" suffix=")" suffixOverrides=",">
      <if test="bookName != null">
        book_name,
      </if>
      <if test="bookAuthor != null">
        book_author,
      </if>
      <if test="bookPublish != null">
        book_publish,
      </if>
      <if test="bookType != null">
        book_type,
      </if>
      <if test="bookIntroduction != null">
        book_introduction,
      </if>
      <if test="isbn != null">
        ISBN,
      </if>
      <if test="money != null">
        money,
      </if>
      <if test="sum != null">
        `sum`,
      </if>
      <if test="num != null">
        num,
      </if>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides=",">
      <if test="bookName != null">
        #{bookName,jdbcType=VARCHAR},
      </if>
      <if test="bookAuthor != null">
        #{bookAuthor,jdbcType=VARCHAR},
      </if>
      <if test="bookPublish != null">
        #{bookPublish,jdbcType=VARCHAR},
      </if>
      <if test="bookType != null">
        #{bookType,jdbcType=VARCHAR},
      </if>
      <if test="bookIntroduction != null">
        #{bookIntroduction,jdbcType=VARCHAR},
      </if>
      <if test="isbn != null">
        #{isbn,jdbcType=VARCHAR},
      </if>
      <if test="money != null">
        #{money,jdbcType=VARCHAR},
      </if>
      <if test="sum != null">
        #{sum,jdbcType=INTEGER},
      </if>
      <if test="num != null">
        #{num,jdbcType=INTEGER},
      </if>
    </trim>
  </insert>
  <update id="updateByPrimaryKeySelective" parameterType="com.gvssimux.pojo.BookInf">
    update bookinf
    <set>
      <if test="bookName != null">
        book_name = #{bookName,jdbcType=VARCHAR},
      </if>
      <if test="bookAuthor != null">
        book_author = #{bookAuthor,jdbcType=VARCHAR},
      </if>
      <if test="bookPublish != null">
        book_publish = #{bookPublish,jdbcType=VARCHAR},
      </if>
      <if test="bookType != null">
        book_type = #{bookType,jdbcType=VARCHAR},
      </if>
      <if test="bookIntroduction != null">
        book_introduction = #{bookIntroduction,jdbcType=VARCHAR},
      </if>
      <if test="isbn != null">
        ISBN = #{isbn,jdbcType=VARCHAR},
      </if>
      <if test="money != null">
        money = #{money,jdbcType=VARCHAR},
      </if>
      <if test="sum != null">
        `sum` = #{sum,jdbcType=INTEGER},
      </if>
      <if test="num != null">
        num = #{num,jdbcType=INTEGER},
      </if>
    </set>
    where id = #{id,jdbcType=INTEGER}
  </update>
  <update id="updateByPrimaryKey" parameterType="com.gvssimux.pojo.BookInf">
    update bookinf
    set book_name = #{bookName,jdbcType=VARCHAR},
      book_author = #{bookAuthor,jdbcType=VARCHAR},
      book_publish = #{bookPublish,jdbcType=VARCHAR},
      book_type = #{bookType,jdbcType=VARCHAR},
      book_introduction = #{bookIntroduction,jdbcType=VARCHAR},
      ISBN = #{isbn,jdbcType=VARCHAR},
      money = #{money,jdbcType=VARCHAR},
      `sum` = #{sum,jdbcType=INTEGER},
      num = #{num,jdbcType=INTEGER}
    where id = #{id,jdbcType=INTEGER}
  </update>

  <select id="searchBook" parameterType="com.gvssimux.pojo.BookInf" resultMap="BaseResultMap">
    select
    <include refid="Base_Column_List" />
    from bookinf
    <where>
      <choose>
        <when test="bookName != null">
          book_name like #{bookName,jdbcType=VARCHAR}
        </when>
        <when test="bookAuthor != null">
          OR book_author like #{bookAuthor,jdbcType=VARCHAR}
        </when>
        <when test="bookPublish != null">
          OR book_publish like #{bookPublish,jdbcType=VARCHAR}
        </when>
        <when test="bookType != null">
          OR book_type like #{bookType,jdbcType=VARCHAR}
        </when>
        <when test="isbn != null">
          OR ISBN like #{isbn,jdbcType=VARCHAR}
        </when>
      </choose>
    </where>
  </select>
</mapper>
```



### Service层

![image-20210104153216109](image\image-20210104153216109.png)

调用Dao层的接口

BookInfService.java

```java
package com.gvssimux.service;

import com.gvssimux.pojo.BookInf;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookInfService {
    int deleteByPrimaryKey(Integer id);

    int insert(BookInf record);

    int insertSelective(BookInf record);

    BookInf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookInf record);

    int updateByPrimaryKey(BookInf record);

    //全部查询
    List<BookInf> selectAll();

    //根据ISBN查询图书信息
    BookInf getBookByIsbn(String isbn);

    //查询书库数量
    int getBookNum();

    //查询书库剩余数量
    int getBookHave();

    //模糊查询（未写完）
    List<BookInf> searchBook(BookInf record);
}

```

BookInfServiceImpl.java

```java
package com.gvssimux.service;

import com.gvssimux.dao.BookInfDao;
import com.gvssimux.pojo.BookInf;

import java.util.List;

public class BookInfServiceImpl implements BookInfService{

    private BookInfDao mapper;

    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(BookInf record) {
        return mapper.insert(record);
    }

    public int insertSelective(BookInf record) {
        return mapper.insertSelective(record);
    }

    public BookInf selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(BookInf record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(BookInf record) {
        return mapper.updateByPrimaryKey(record);
    }

    public List<BookInf> selectAll(){
        return mapper.selectAll();
    }

    @Override
    public BookInf getBookByIsbn(String isbn) {
        return mapper.getBookByIsbn(isbn);
    }

    @Override
    public int getBookNum() {
        return mapper.getBookNum();
    }

    @Override
    public int getBookHave() {
        return mapper.getBookHave();
    }

    @Override
    public List<BookInf> searchBook(BookInf record) {
        return mapper.searchBook(record);
    }

    public void setMapper(BookInfDao mapper) {
        this.mapper = mapper;
    }
}

```



### Controller层

![image-20210104153359535](image\image-20210104153359535.png)

```java
package com.gvssimux.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.BookInf;
import com.gvssimux.service.BookInfServiceImpl;
import com.gvssimux.service.CommentServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.List;

@Controller
public class BookInfController {

    /**
     * 跳转页面
     */
    @RequestMapping("/tobookinf")
    public String toBookInf(Model model){

        return "bookinf";
    }


    /**
     * 全部查询
     */
    @ResponseBody
    @RequestMapping("/allbook")
    public String getAllBook() throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        System.out.println("执行成功=====》:"+bookInfServiceImpl.selectAll());
        JsonUtil jsonUtil = new JsonUtil();
        return jsonUtil.getJson(bookInfServiceImpl.selectAll());
    }

    /**
     * 单个查询
     */
    @ResponseBody
    @RequestMapping("/onebook")
    public String getOneBook(String isbn) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        System.out.println(isbn);
        return jsonUtil.getJson(bookInfServiceImpl.getBookByIsbn(isbn));
    }


    /**
     * 部分修改
     */
    @ResponseBody
    @RequestMapping("/bookchange")
    public String changeBook(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        //创建接收对象
        BookInf object = new BookInf();
        object.setIsbn(request.getParameter("isbn"));
        object.setBookName(request.getParameter("bookName"));
        object.setBookAuthor(request.getParameter("bookAuthor"));
        object.setBookPublish(request.getParameter("bookPublish"));
        object.setBookIntroduction(request.getParameter("bookIntroduction"));
        object.setBookType(request.getParameter("bookType"));
        object.setMoney(request.getParameter("money"));
        object.setSum(Integer.valueOf(request.getParameter("sum")));
        object.setNum(Integer.valueOf(request.getParameter("num")));
        object.setId(Integer.valueOf(request.getParameter("bookId")));

        bookInfServiceImpl.updateByPrimaryKeySelective(object);
        //System.out.println("======================"+request.getParameter("bookName")+"====================");
        return jsonUtil.getJson(object.getIsbn());
    }

    /**
     * 查询书籍评论
     */
    @ResponseBody
    @RequestMapping("/getcomm")
    public String getComment(String isbn) throws JsonProcessingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CommentServiceImpl mapper = context.getBean("CommentServiceImpl", CommentServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        System.out.println(isbn);
        return jsonUtil.getJson(mapper.getCommentByIsbn(isbn));
    }

    /**
     * 模糊查询
     */

    @RequestMapping("/search")
    public void getA(HttpServletRequest request, HttpServletResponse response){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookInfServiceImpl bookInfServiceImpl = context.getBean("BookServiceImpl", BookInfServiceImpl.class);
        JsonUtil jsonUtil = new JsonUtil();
        //创建接收对象
        BookInf object = new BookInf();
        object.setIsbn(request.getParameter("bookIsbn"));
        object.setBookName(request.getParameter("bookName"));
        object.setBookAuthor(request.getParameter("bookAuthor"));
        object.setBookPublish(request.getParameter("bookPublish"));
        object.setBookType(request.getParameter("bookType"));
        object.setId(Integer.valueOf(request.getParameter("bookId")));

        System.out.println("执行成功=====》:"+bookInfServiceImpl.searchBook(object));
    }

}

```



## 前端目录

![image-20210104154131490](image\image-20210104154131490.png)

所有的页面在WEB-INF下反正用户的直接访问，只可通过index.jsp进行跳转

# 团队协作

## Maven

构建统一的环境

```xml

    <!--导入依赖-->
    <dependencies>
        <!--lombok-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
        </dependency>

        <!--jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.11.2</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.71</version>
        </dependency>
        <!--Junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <!--  作用域<scope>test</scope>-->
        </dependency>
        <!--数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.13</version>
        </dependency>
        <!-- 数据库连接池 -->
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.5.5</version>
        </dependency>
        <!--Servlet - JSP -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <!--Mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.5</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.5</version>
        </dependency>

        <!--Spring-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.7.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.7.RELEASE</version>
        </dependency>
        <!--aspectjweaver -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.6</version>
        </dependency>

        <!--log4j-core -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <dependency>
            <groupId>com.gvssimux</groupId>
            <artifactId>BooksManagementSystem</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>


    </dependencies>

    <!--    在build中配置resources,来防止我们资源导出失败的问题  -->
    <build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
```

## Git

我们使用到了Git进行版本控制，协同开发

![image-20210104152638416](image\image-20210104152638416.png)



# 优化

## 数据库

。。。。

## Mybatis二级缓存

![image-20210104153916311](image\image-20210104153916311.png)

```xml
<settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
        <setting name="logImpl" value="LOG4J"/>
        <!--显示的开启全局缓存-->
        <setting name="cacheEnabled" value="false"/>
</settings>
```

![image-20210104153952178](image\image-20210104153952178.png)

```xml
 <!--在当前Mapper.xml中使用二级缓存-->
  <cache  eviction="FIFO"
          flushInterval="60000"
          size="512"
          readOnly="true"/>
```

