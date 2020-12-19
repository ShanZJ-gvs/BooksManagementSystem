package com.gvssimux.dao;

import com.gvssimux.pojo.BookInf;
import com.gvssimux.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询全部user，不带密码
    @Select("select userid,uname,`user`,sign,time from `user`")
    List<User> selectAll();

    //根据Id查询
    @Select("select * from user where userid = #{userid}")
    User selectByUserId(@Param("userid") String userid);

    //查询用户数量
    @Select("SELECT COUNT(*) FROM\n `user`")
    int getUserNum();
}