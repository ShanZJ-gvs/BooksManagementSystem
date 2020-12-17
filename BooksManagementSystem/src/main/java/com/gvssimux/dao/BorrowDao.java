package com.gvssimux.dao;

import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.Borrow;
import com.gvssimux.pojo.webPojo.BookBorrUser;
import com.gvssimux.pojo.webPojo.BorrUser;
import org.apache.ibatis.annotations.Select;

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
    @Select("SELECT\n" +
            "\tbookinf.book_author, \n" +
            "\tbookinf.book_publish, \n" +
            "\tbookinf.book_type, \n" +
            "\tbookinf.book_introduction, \n" +
            "\tbookinf.money, \n" +
            "\tbookinf.sum, \n" +
            "\tbookinf.num, \n" +
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
            "\tborrow.userid\n" +
            "FROM\n" +
            "\tborrow\n" +
            "\tINNER JOIN\n" +
            "\t`user`\n" +
            "\tON \n" +
            "\t\tborrow.userid = `user`.userid\n" +
            "\tINNER JOIN\n" +
            "\tbookinf\n" +
            "\tON \n" +
            "\t\tbookinf.ISBN = borrow.isbn\n" +
            "WHERE\n" +
            "\tborrow.`status` = \"待归还\" OR\n" +
            "\tborrow.`status` = \"待借出\"\n" +
            " OR\n" +
            "\tborrow.`status` = \"逾期\"")
    List<BookBorrUser> get3Table();



}