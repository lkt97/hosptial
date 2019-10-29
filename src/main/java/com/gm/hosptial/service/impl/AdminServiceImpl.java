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

    @Resource(name = "patientinfoMapper")
    private patientinfoMapper paM;
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
        List<patientinfo> palist=paM.select();
        return palist;
    }

    @Override
    public List<doctorinfo> getDoctorinfo() {
        List<doctorinfo> doclist=docM.select();
        return doclist;
    }

    @Override
    public boolean setPatientinfotime(patientinfo pinfo, int time) {
        pinfo.setFreezetime(time);
        int n=paM.updateByPrimaryKey(pinfo);
        if(n==0)
        return false;
        else
            return true;
    }

    @Override
    public List<docleaveinfo> getDocleaveinfo() {
        List<docleaveinfo> doclist=docL.select();
        return doclist;
    }

    @Override
    public boolean setDocleaveinfo(docleaveinfo docl) {
        int n=0;
        if(docL.selectByPrimaryKey(docl)!=null) {
            n=docL.update(docl);
        }
        if (n==0)
        return false;
        else
            return true;
    }
}
