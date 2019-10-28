package com.gm.hosptial.service.impl;

import com.gm.hosptial.mapper.*;
import com.gm.hosptial.pojo.*;
import com.gm.hosptial.service.AdminService;

import javax.annotation.Resource;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Resource(name = "docleaveinfoMapper")
    private docleaveinfoMapper docL;

    @Resource(name = "doctorinfoMapper")
    private doctorinfoMapper docM;

    @Resource(name = "appointinfoMapper")
    private appointinfoMapper appM;

    @Resource(name = "appointrecordMapper")
    private appointrecordMapper appdM;

    @Resource(name = "visitrecordMapper")
    private visitrecordMapper visM;

    @Resource(name = "departmentinfoMapper")
    private departmentinfoMapper depM;

    @Resource(name = "scheduleinfoMapper")
    private scheduleinfoMapper schM;
    @Override
    public boolean addepaDrtment(departmentinfo dep) {
        int n=0;
        if (depM.selectByPrimaryKey(dep.getDepartmentid())!=null)
        {
            n=depM.insert(dep);
        }
        if(n==0)
            return false;
        else
            return true;
    }

    @Override
    public boolean addDoctor(doctorinfo dinfo, String id) {
        int n =0;
        if (depM.selectByPrimaryKey(dinfo.getDocpassword())!=null){
            if(docM.selectByPrimaryKey(dinfo.getDoctorid())==null){
                n=docM.insert(dinfo);
            }
        }
        if(n==0)
            return false;
        else
            return true;
    }

    @Override
    public boolean deleteDoctor(String did) {
        int n=0;
        n=docM.deleteByPrimaryKey(did);
        if (n == 0 )
        return false;
        else
            return true;
    }

    @Override
    public boolean upDoctor(doctorinfo did) {
        int n=docM.updateByPrimaryKey(did);
        if (n==0)
            return false;
        else
            return true;
    }

    @Override
    public scheduleinfo getScheduleinfo(String did) {
        scheduleinfo sche=schM.selectByPrimaryKey(did);
        return sche;
    }

    @Override
    public boolean setDepartment(scheduleinfo sinfo) {
        int n=0;
        if (docM.selectByPrimaryKey(sinfo.getDoctorid())!=null){
            if (schM.selectByPrimaryKey(sinfo.getDoctorid())!=null){
                n=schM.updateByPrimaryKey(sinfo);
            }
            else{
                n=schM.insert(sinfo);
            }

        }
        if (n==0)
            return false;
        else
            return true;
    }

    @Override
    public List<patientinfo> getPatientinfo() {
        return null;
    }

    @Override
    public List<doctorinfo> getDoctorinfo() {
        return null;
    }

    @Override
    public boolean setPatientinfotime(patientinfo pinfo, String time) {
        return false;
    }

    @Override
    public List<docleaveinfo> getDocleaveinfo() {
        return null;
    }

    @Override
    public boolean setDocleaveinfo(docleaveinfo docl) {
        return false;
    }
}
