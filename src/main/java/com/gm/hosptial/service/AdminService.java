package com.gm.hosptial.service;

import com.gm.hosptial.pojo.*;

import java.util.List;

public interface AdminService {
    //管理员增加科室
    public boolean addepaDrtment(departmentinfo dep);
    //管理员增加医生
    public boolean addDoctor(doctorinfo dinfo,String id);
    //管理员删除医生
    public boolean deleteDoctor(String did);
    //管理员修改医生
    public boolean upDoctor(doctorinfo did);
    //获取排班表
    public scheduleinfo getScheduleinfo(String did);
    //管理员安排医生排班
    public boolean setDepartment(scheduleinfo sinfo);
    //管理员查看患者信息
    public List<patientinfo> getPatientinfo();
    //管理员查看医生信息
    public List<doctorinfo> getDoctorinfo();
    //管理员解冻/冻结用户
    public boolean setPatientinfotime(patientinfo pinfo,String time);
    //管理员查看未审批假条
    public List<docleaveinfo> getDocleaveinfo();
    //管理员审批假条
    public boolean setDocleaveinfo(docleaveinfo docl);
}
