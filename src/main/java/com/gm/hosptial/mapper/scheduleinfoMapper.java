package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.scheduleinfo;

public interface scheduleinfoMapper {
    int deleteByPrimaryKey(String doctorid);

    int insert(scheduleinfo record);

    int insertSelective(scheduleinfo record);

    scheduleinfo selectByPrimaryKey(String doctorid);

    int updateByPrimaryKeySelective(scheduleinfo record);

    int updateByPrimaryKey(scheduleinfo record);
}