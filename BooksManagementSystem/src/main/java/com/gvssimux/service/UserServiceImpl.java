package com.gvssimux.service;


import com.gvssimux.dao.UserDao;
import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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


    public List<User> selectAll(){
        return mapper.selectAll();
    }


    public User selectByUserId(String userid) {
        return mapper.selectByUserId(userid);
    }


    public int getUserNum() {
        return mapper.getUserNum();
    }


    public User getUserIdByUserNamePwd(String username, String pwd) {
        return mapper.getUserIdByUserNamePwd(username, pwd);
    }

    //2021-写
    //注册---验证用户名是否在数据中

    public int getUserByUser(String user){
        if (mapper.getUserByUser(user)==null){
            return 0;
        }
        if(mapper.getUserByUser(user).equals(user))
            return 1;
        return 0;
    }


    public void setMapper(UserDao mapper) {
        this.mapper = mapper;
    }
}
