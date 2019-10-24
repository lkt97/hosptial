package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.visitrecord;

public interface visitrecordMapper {
    int insert(visitrecord record);

    int insertSelective(visitrecord record);
}