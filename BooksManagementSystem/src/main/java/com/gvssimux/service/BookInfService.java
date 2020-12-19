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

    List<BookInf> selectAll();

    //查询书库数量
    int getBookNum();
}
