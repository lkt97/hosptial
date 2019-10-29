package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.doctorinfo;

import java.util.List;

public interface doctorinfoMapper {
    int deleteByPrimaryKey(String doctorid);

    int insert(doctorinfo record);

    int insertSelective(doctorinfo record);

    doctorinfo selectByPrimaryKey(String doctorid);

    List<doctorinfo> select();

    int updateByPrimaryKeySelective(doctorinfo record);

    int updateByPrimaryKey(doctorinfo record);
}