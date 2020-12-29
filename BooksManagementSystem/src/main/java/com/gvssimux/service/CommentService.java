package com.gvssimux.service;

import com.gvssimux.pojo.Comment;

public interface CommentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    //查询评论
    Comment getCommentByIsbn(String isbn);
}
