package com.gm.hosptial.service.impl;

import com.gm.hosptial.mapper.*;
import com.gm.hosptial.pojo.*;
import com.gm.hosptial.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {
    @Resource(name = "docleaveinfoMapper")
    private docleaveinfoMapper docL;

    @Resource(name = "doctorinfoMapper")
    private doctorinfoMapper docM;

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

    @Resource(name = "numberinfoMapper")
    private numberinfoMapper numM;
    @Override
    public boolean addepaDrtment(departmentinfo dep) {
        int n=0;
        if (depM.selectByPrimaryKey(dep.getDepartmentid())==null)
        {
            n=depM.insert(dep);
        }
        if(n==0)
            return false;
        else
            return true;
    }

    @Override
    public int countdepaDrtment() {
        Page page=new Page();
        return depM.count(page);
    }

    @Override
    public List<departmentinfo> getdepaDrtmentlist(Page page) {
        List<departmentinfo> dep=depM.select(page);
        return dep;
    }

    @Override
    public departmentinfo getdepaDrtment(String dep) {

        return depM.selectByPrimaryKey(dep);
    }

    @Override
    public departmentinfo getdepaDrtmenttwo(String dep) {

        return depM.selectByPrimaryKeytwo(dep);
    }

    @Override
    public boolean addDoctor(doctorinfo dinfo) {
        int n =0;
        n=docM.insert(dinfo);
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
    public boolean setNumber(numberinfo number) {
        int n=0;
        if (numM.selectpa(number)!=null){
        n=numM.updates(number);
        }
        else{
            n=numM.insert(number);
        }
        if (n==0)
        return false;
        else
            return true;
    }

    @Override
    public List<patientinfo> getPatientinfo(Page page) {
        List<patientinfo> palist=paM.selects(page);
        return palist;
    }

    @Override
    public int gcountPatientinfo() {
        return paM.count();
    }

    @Override
    public List<doctorinfo> getDoctorinfo() {
        List<doctorinfo> doclist=docM.select();
        return doclist;
    }

    @Override
    public List<doctorinfo> getDoctorinfos(doctorinfo doctorinfo) {
        return docM.selectByname(doctorinfo);
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
    public List<docleaveinfo> getDocleaveinfo(Page page) {
        List<docleaveinfo> doclist=docL.selectdoc(page);
        return doclist;
    }

    @Override
    public docleaveinfo getDocleaveinfo(docleaveinfo docleaveinfo) {
        return docL.selectByPrimaryKey(docleaveinfo);
    }

    @Override
    public boolean setNoDocleaveinfo(docleaveinfo docl) {
        int n=0;
        if(docL.selectByPrimaryKey(docl)!=null) {
            n=docL.updateno(docl);
        }
        if (n==0)
            return false;
        else
            return true;
    }

    @Override
    public boolean setSaveDocleaveinfo(docleaveinfo docl) {
        int n=0;
        if(docL.selectByPrimaryKey(docl)!=null) {
            n=docL.updatesave(docl);
        }
        if (n==0)
        return false;
        else
            return true;
    }
}
