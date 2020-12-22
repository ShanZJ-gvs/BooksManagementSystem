package com.gvssimux.service;

import com.gvssimux.dao.BookInfDao;
import com.gvssimux.pojo.BookInf;

import java.util.List;

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

    public List<BookInf> selectAll(){
        return mapper.selectAll();
    }

    @Override
    public BookInf getBookByIsbn(String isbn) {
        return mapper.getBookByIsbn(isbn);
    }

    @Override
    public int getBookNum() {
        return mapper.getBookNum();
    }

    @Override
    public int getBookHave() {
        return mapper.getBookHave();
    }

    public void setMapper(BookInfDao mapper) {
        this.mapper = mapper;
    }
}
