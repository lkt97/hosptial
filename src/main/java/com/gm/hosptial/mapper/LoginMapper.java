package com.gm.hosptial.mapper;

import com.gm.hosptial.pojo.patientinfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public interface LoginMapper {
    patientinfo login(HashMap<String, Object> map);
}
