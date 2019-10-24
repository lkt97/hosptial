package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.appointrecord;

public interface appointrecordMapper {
    int deleteByPrimaryKey(String patientid);

    int insert(appointrecord record);

    int insertSelective(appointrecord record);

    appointrecord selectByPrimaryKey(String patientid);

    int updateByPrimaryKeySelective(appointrecord record);

    int updateByPrimaryKey(appointrecord record);

    appointrecord select(String patientid);
}