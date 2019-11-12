package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.Page;
import com.gm.hosptial.pojo.departmentinfo;

import java.util.List;

public interface departmentinfoMapper {
    int deleteByPrimaryKey(String departmentid);

    int insert(departmentinfo record);

    int insertSelective(departmentinfo record);

    departmentinfo selectByPrimaryKey(String departmentid);

    departmentinfo selectByPrimaryKeytwo(String departmentname);

    int updateByPrimaryKeySelective(departmentinfo record);

    int updateByPrimaryKey(departmentinfo record);

    List<departmentinfo> select(Page page);

    int count(Page page);
}