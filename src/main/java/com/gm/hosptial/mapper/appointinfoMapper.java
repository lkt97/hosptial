package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.appointinfo;

public interface appointinfoMapper {
    int deleteByPrimaryKey(String patientid);

    int insert(appointinfo record);

    int insertSelective(appointinfo record);

    appointinfo selectByPrimaryKey(String patientid);

    int updateByPrimaryKeySelective(appointinfo record);

    int updateByPrimaryKey(appointinfo record);
}