package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.departmentinfo;

public interface departmentinfoMapper {
    int deleteByPrimaryKey(String departmentid);

    int insert(departmentinfo record);

    int insertSelective(departmentinfo record);

    departmentinfo selectByPrimaryKey(String departmentid);

    int updateByPrimaryKeySelective(departmentinfo record);

    int updateByPrimaryKey(departmentinfo record);
}