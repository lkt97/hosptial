package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.Page;
import com.gm.hosptial.pojo.appointrecord;

import java.util.List;

public interface appointrecordMapper {
    int deleteByPrimaryKey(String patientid);

    int insert(appointrecord record);

    int insertSelective(appointrecord record);

    appointrecord selectByPrimaryKey(String number);

    int updateByPrimaryKeySelective(appointrecord record);

    int updateByPrimaryKey(appointrecord record);

    appointrecord select(String patientid);

    List<appointrecord> selectpa(String docid);
    int count(String doctorid);
}