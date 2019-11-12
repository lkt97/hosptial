package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.Page;
import com.gm.hosptial.pojo.appointrecord;

import java.util.List;

public interface appointrecordMapper {
    int deleteByPrimaryKey(String number);

    int insert(appointrecord record);

    int insertSelective(appointrecord record);

    List<appointrecord> selectByPrimaryKey(String patientid);

    int updateByPrimaryKeySelective(appointrecord record);

    int updateByPrimaryKey(appointrecord record);

    appointrecord select(String number);

    List<appointrecord> selectpa(Page page);
    int count(String doctorid);
}