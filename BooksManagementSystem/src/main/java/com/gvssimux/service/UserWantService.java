package com.gvssimux.service;

import com.gvssimux.pojo.User;
import com.gvssimux.pojo.UserWant;
import com.gvssimux.pojo.webPojo.UserWantUser;

import java.util.List;

public interface UserWantService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWant record);

    int insertSelective(UserWant record);

    UserWant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWant record);

    int updateByPrimaryKey(UserWant record);

    //查询全部userWant
    List<UserWantUser> getAll();
}
