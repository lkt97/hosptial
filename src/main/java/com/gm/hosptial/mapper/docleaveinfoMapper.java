package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.Page;
import com.gm.hosptial.pojo.docleaveinfo;

import java.util.List;

public interface docleaveinfoMapper {

    int insert(docleaveinfo record);

    List<docleaveinfo> select(Page page);

    List<docleaveinfo> selectdoc(Page page);

    docleaveinfo selectByPrimaryKey(docleaveinfo record);

    int count(docleaveinfo record);

    int update(docleaveinfo record);

    int updatesave(docleaveinfo record);

    int updateno(docleaveinfo record);

    int insertSelective(docleaveinfo record);

    int deleteByPrimaryKey(docleaveinfo record);
}