package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.numberinfo;

public interface numberinfoMapper {
    int deleteByPrimaryKey(String doctorid);

    int insert(numberinfo record);

    int insertSelective(numberinfo record);

    numberinfo selectByPrimaryKey(String doctorid);

    int updateByPrimaryKeySelective(numberinfo record);

    int updateByPrimaryKey(numberinfo record);
}