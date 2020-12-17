package com.gvssimux.dao;

import com.gvssimux.pojo.User;
import com.gvssimux.pojo.UserWant;
import com.gvssimux.pojo.webPojo.UserWantUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserWantDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWant record);

    int insertSelective(UserWant record);

    UserWant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWant record);

    int updateByPrimaryKey(UserWant record);

    //查询全部userWant
    @Select("SELECT\n" +
            "\tuserwant.userid, \n" +
            "\tuserwant.bookname, \n" +
            "\tuserwant.author, \n" +
            "\tuserwant.publish, \n" +
            "\tuserwant.ps, \n" +
            "\tuserwant.`status`, \n" +
            "\t`user`.uname, \n" +
            "\t`user`.`user`, \n" +
            "\t`user`.sign, \n" +
            "\t`user`.time\n" +
            "FROM\n" +
            "\t`user`\n" +
            "\tINNER JOIN\n" +
            "\tuserwant\n" +
            "\tON \n" +
            "\t\t`user`.userid = userwant.userid")
    List<UserWantUser> getAll();

}