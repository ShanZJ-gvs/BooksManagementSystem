package com.gvssimux.service;

import com.gvssimux.dao.BorrowDao;
import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.Borrow;
import com.gvssimux.pojo.webPojo.BookBorrUser;
import com.gvssimux.pojo.webPojo.BorrUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowService {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

    //两表关联查询user和borrow
    List<BorrUser> selectAll();

    //三表关联查询user和borrow和bookinf
    List<BookBorrUser> get3Table();

    //查询每月借书的总数，以申请时间为准
    int getPerSum(String month);
}
