package com.gvssimux.service;

import com.gvssimux.dao.BorrowDao;
import com.gvssimux.pojo.Borrow;

import java.util.List;

public class BorrowServiceImpl implements BorrowService{

    private BorrowDao mapper;

    public void setMapper(BorrowDao mapper) {
        this.mapper = mapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Borrow record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Borrow record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Borrow selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Borrow record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Borrow record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Borrow> selectAll() {
        return mapper.selectAll();
    }
}
