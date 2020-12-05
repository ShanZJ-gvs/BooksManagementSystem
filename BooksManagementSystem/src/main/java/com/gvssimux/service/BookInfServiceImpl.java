package com.gvssimux.service;

import com.gvssimux.dao.BookInfDao;
import com.gvssimux.pojo.BookInf;

public class BookInfServiceImpl implements BookInfService{

    private BookInfDao mapper;

    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(BookInf record) {
        return mapper.insert(record);
    }

    public int insertSelective(BookInf record) {
        return mapper.insertSelective(record);
    }

    public BookInf selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(BookInf record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(BookInf record) {
        return mapper.updateByPrimaryKey(record);
    }

    public void setMapper(BookInfDao mapper) {
        this.mapper = mapper;
    }
}