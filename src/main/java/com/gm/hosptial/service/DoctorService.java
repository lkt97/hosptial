package com.gm.hosptial.service;

import com.gm.hosptial.pojo.*;

import java.util.List;

public interface DoctorService {
    //医生登录
    public boolean doctorLogin(String user,String password);
    //获得医生资料
    public doctorinfo getDoctor(String id);
    //更新医生资料
    public boolean upDoctor(doctorinfo dinfo);
    //提交医生请假
    public boolean leaveDoctor(docleaveinfo dlinfo);
    //确认预约，并生成就诊信息（）
    public boolean appointAffirm(appointrecord apoint,String did);
    //根据患者id和医生id获得就诊信息
    public List<visitrecord> getVisitrecord(String aid, String did);
}
