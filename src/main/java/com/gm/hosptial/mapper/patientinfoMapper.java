package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.patientinfo;

import java.util.HashMap;
import java.util.List;

public interface patientinfoMapper {
    int deleteByPrimaryKey(String patientid);

    int insert(patientinfo record);

    int insertSelective(patientinfo record);

    patientinfo selectByPrimaryKey(String patientid);

    List<patientinfo> select();

    int updateByPrimaryKeySelective(patientinfo record);

    int updateByPrimaryKey(patientinfo record);

    patientinfo login(HashMap<String, Object> map);

}