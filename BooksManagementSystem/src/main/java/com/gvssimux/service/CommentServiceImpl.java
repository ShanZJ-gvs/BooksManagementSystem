package com.gvssimux.service;

import com.gvssimux.dao.CommentDao;
import com.gvssimux.pojo.Comment;

public class CommentServiceImpl implements CommentService{
    private CommentDao mapper;

    public void setMapper(CommentDao mapper) {
        this.mapper = mapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public Comment getCommentByIsbn(String isbn) {
        return mapper.getCommentByIsbn(isbn);
    }
}
