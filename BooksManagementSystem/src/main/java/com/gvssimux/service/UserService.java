package com.gvssimux.service;

import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询全部user，不带密码
    List<User> selectAll();

    //根据Id查询
    User selectByUserId(String userid);



}
