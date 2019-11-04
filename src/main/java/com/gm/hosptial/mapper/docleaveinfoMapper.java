package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.docleaveinfo;

import java.util.List;

public interface docleaveinfoMapper {

    int insert(docleaveinfo record);

    List<docleaveinfo> select();

    List<docleaveinfo> selectByPrimaryKey(docleaveinfo record);

    int update(docleaveinfo record);

    int insertSelective(docleaveinfo record);

    int deleteByPrimaryKey(docleaveinfo record);
}