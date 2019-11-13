package com.gm.hosptial.service;

import com.gm.hosptial.pojo.*;

import java.util.List;

public interface AdminService {
    //管理员增加科室
    public boolean addepaDrtment(departmentinfo dep);
    //管理员科室总数
    public int countdepaDrtment();
    //管理员获得科室
    public departmentinfo getdepaDrtment(String dep);
    //管理员获得科室
    public departmentinfo getdepaDrtmenttwo(String dep);
    //管理员获得所有科室
    public List<departmentinfo> getdepaDrtmentlist(Page page);
    //管理员增加医生
    public boolean addDoctor(doctorinfo dinfo);
    //管理员删除医生
    public boolean deleteDoctor(String did);
    //管理员修改医生
    public boolean upDoctor(doctorinfo did);
    //获取排班表
    public scheduleinfo getScheduleinfo(String did);
    //管理员安排医生排班
    public boolean setDepartment(scheduleinfo sinfo);
    //管理员安排医生号源
    public boolean setNumber(numberinfo number);
    //管理员查看患者信息
    public List<patientinfo> getPatientinfo(Page page);
    //管理员获得患者总数
    public int gcountPatientinfo();
    //管理员查看医生信息
    public List<doctorinfo> getDoctorinfo(Page page);
    //管理员查看医生信息总数
    public int countDoctorinfo(Page page);
    //管理员查看医生信息
    public List<doctorinfo> getDoctorinfos(doctorinfo doctorinfo);
    //管理员解冻/冻结用户
    public boolean setPatientinfotime(patientinfo pinfo,int time);
    //管理员查看未审批假条
    public List<docleaveinfo> getDocleaveinfo(Page page);;
    //管理员查看某条未审批假条
    public docleaveinfo getDocleaveinfo(docleaveinfo docleaveinfo);
    //管理员审批假条
    public boolean setSaveDocleaveinfo(docleaveinfo docl);
    //管理员拒绝假条
    public boolean setNoDocleaveinfo(docleaveinfo docl);
}
