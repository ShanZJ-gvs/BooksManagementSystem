package com.gvssimux.dao;

import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.Borrow;
import com.gvssimux.pojo.webPojo.BookBorrUser;
import com.gvssimux.pojo.webPojo.BorrUser;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface BorrowDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);


    //两表关联查询user和borrow
    @Select("SELECT\n" +
            "\tborrow.userid, \n" +
            "\tborrow.borrowid, \n" +
            "\tborrow.bookname, \n" +
            "\tborrow.isbn, \n" +
            "\tborrow.`status`, \n" +
            "\tborrow.starttime, \n" +
            "\tborrow.starttime2, \n" +
            "\tborrow.endtime2, \n" +
            "\tborrow.endtime, \n" +
            "\t`user`.uname, \n" +
            "\t`user`.`user`, \n" +
            "\t`user`.sign, \n" +
            "\t`user`.time\n" +
            "FROM\n" +
            "\tborrow\n" +
            "\tINNER JOIN\n" +
            "\t`user`\n" +
            "\tON \n" +
            "\t\tborrow.userid = `user`.userid")
    List<BorrUser> selectAll();

    //三表关联查询user和borrow和bookinf
    @Select("SELECT bookinf.book_author,  bookinf.book_publish,  bookinf.book_type,  bookinf.book_introduction,  bookinf.money,  bookinf.sum,  bookinf.num,  borrow.borrowid,  borrow.bookname,  borrow.isbn,  borrow.`status`,  borrow.starttime,  borrow.starttime2,  borrow.endtime2,  borrow.endtime,  `user`.uname,  `user`.`user`,  `user`.sign,  borrow.userid\n" +
            "FROM borrow INNER JOIN `user` ON borrow.userid = `user`.userid INNER JOIN bookinf ON  \tbookinf.ISBN = borrow.isbn\n" +
            "WHERE borrow.`status` = '待归还' OR borrow.`status` = '待借出'" +
            " OR borrow.`status` = '逾期'")
    List<BookBorrUser> get3Table();

    //三表关联查询user和borrow和bookinf
    @Select("SELECT bookinf.book_author,  bookinf.book_publish,  bookinf.book_type,  bookinf.book_introduction,  bookinf.money,  bookinf.sum,  bookinf.num,  borrow.borrowid,  borrow.bookname,  borrow.isbn,  borrow.`status`,  borrow.starttime,  borrow.starttime2,  borrow.endtime2,  borrow.endtime,  `user`.uname,  `user`.`user`,  `user`.sign,  borrow.userid\n" +
            "FROM borrow INNER JOIN `user` ON borrow.userid = `user`.userid INNER JOIN bookinf ON  \tbookinf.ISBN = borrow.isbn\n" +
            "WHERE borrow.`status` = '待借出'")
    List<BookBorrUser> get3Table2();

    //查询每月借书的总数，以申请时间为准
    @Select("SELECT COUNT(*) FROM borrow WHERE borrow.starttime LIKE #{month}")
    int getPerSum(@Param("month") String month);


    //查询借阅总量
    @Select("SELECT COUNT(*) FROM `borrow`")
    int getBorrowNum();


    //查询逾期总量
    @Select("SELECT COUNT(*)  FROM  borrow  WHERE   borrow.endtime2 < #{data}")
    int getOverNum(Date date);


    //待归还数量
    @Select("SELECT COUNT(borrow.`status`) FROM borrow WHERE borrow.`status` = '待归还'")
    int getOutBookNum(Date date);





}