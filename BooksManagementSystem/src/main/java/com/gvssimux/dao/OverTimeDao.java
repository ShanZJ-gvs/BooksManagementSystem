package com.gvssimux.dao;

import com.gvssimux.pojo.OverTime;

public interface OverTimeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OverTime record);

    int insertSelective(OverTime record);

    OverTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OverTime record);

    int updateByPrimaryKey(OverTime record);
}