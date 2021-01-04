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
