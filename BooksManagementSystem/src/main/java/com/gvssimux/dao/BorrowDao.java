package com.gvssimux.dao;

import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.Borrow;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer id);

    @Select("select * from borrow")
    List<Borrow> selectAll();

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
}