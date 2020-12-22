package com.gvssimux.dao;

import com.gvssimux.pojo.BookInf;
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

}