package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.idinfo;

public interface idinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(idinfo record);

    int insertSelective(idinfo record);

    idinfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(idinfo record);

    int updateByPrimaryKey(idinfo record);
}