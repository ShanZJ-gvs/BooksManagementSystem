package com.gvssimux.service;

import com.gvssimux.pojo.Borrow;

public interface BorrowService {
    int deleteByPrimaryKey(Integer id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    Borrow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
}
