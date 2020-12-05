package com.gvssimux.service;


import com.gvssimux.dao.UserDao;
import com.gvssimux.pojo.User;

public class UserServiceImpl implements UserService{
    private UserDao mapper;

    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(User record) {
        return mapper.insert(record);
    }

    public int insertSelective(User record) {
        return mapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record) {
        return mapper.updateByPrimaryKey(record);
    }


    public void setMapper(UserDao mapper) {
        this.mapper = mapper;
    }
}
