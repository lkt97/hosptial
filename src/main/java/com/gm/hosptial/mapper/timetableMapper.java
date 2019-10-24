package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.timetable;

public interface timetableMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(timetable record);

    int insertSelective(timetable record);

    timetable selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(timetable record);

    int updateByPrimaryKey(timetable record);
}