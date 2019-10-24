package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.doctorinfo;

public interface doctorinfoMapper {
    int deleteByPrimaryKey(String doctorid);

    int insert(doctorinfo record);

    int insertSelective(doctorinfo record);

    doctorinfo selectByPrimaryKey(String doctorid);

    int updateByPrimaryKeySelective(doctorinfo record);

    int updateByPrimaryKey(doctorinfo record);
}