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
}