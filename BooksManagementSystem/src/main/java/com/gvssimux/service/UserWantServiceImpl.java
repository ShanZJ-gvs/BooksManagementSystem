package com.gvssimux.service;

import com.gvssimux.dao.UserWantDao;
import com.gvssimux.pojo.User;
import com.gvssimux.pojo.UserWant;
import com.gvssimux.pojo.webPojo.UserWantUser;

import java.util.List;

public class UserWantServiceImpl implements UserWantService{

    private UserWantDao mapper;

    public void setMapper(UserWantDao mapper) {
        this.mapper = mapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserWant record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(UserWant record) {
        return mapper.insertSelective(record);
    }

    @Override
    public UserWant selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserWant record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserWant record) {
        return mapper.updateByPrimaryKey(record);
    }

    //查询全部userWant
    @Override
    public List<UserWantUser> getAll() {
        return mapper.getAll();
    }
}
