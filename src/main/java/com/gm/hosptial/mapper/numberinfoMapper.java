package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.numberinfo;

import java.util.List;

public interface numberinfoMapper {
    int deleteByPrimaryKey(String doctorid);

    int insert(numberinfo record);

    int insertSelective(numberinfo record);

    numberinfo selectByPrimaryKey(String doctorid);

    int updateByPrimaryKeySelective(numberinfo record);

    int updateByPrimaryKey(numberinfo record);

    List<numberinfo> select(String doctorid);

    int update(numberinfo numberinfo);

    int updates(numberinfo numberinfo);

    numberinfo selectpa(numberinfo record);
}