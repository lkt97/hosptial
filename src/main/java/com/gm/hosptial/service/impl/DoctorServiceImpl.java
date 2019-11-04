package com.gm.hosptial.service.impl;

import com.gm.hosptial.mapper.*;
import com.gm.hosptial.pojo.*;
import com.gm.hosptial.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("doctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {
    @Resource(name = "docleaveinfoMapper")
    private docleaveinfoMapper docL;

    @Resource(name = "doctorinfoMapper")
    private doctorinfoMapper docM;
    @Resource(name = "appointrecordMapper")
    private appointrecordMapper appdM;

    @Resource(name = "visitrecordMapper")
    private  visitrecordMapper visM;

    @Resource(name = "scheduleinfoMapper")
    private scheduleinfoMapper schM;
    @Override
    public boolean doctorLogin(String user, String password) {
        doctorinfo docinfo = docM.selectByPrimaryKey(user);
        if(docinfo!=null)
        {
            if(docinfo.getDoctorid().equals(user)&&docinfo.getDocpassword().equals(password))
                return true;
        }
        return false;
    }

    @Override
    public doctorinfo getDoctor(String id) {
        doctorinfo docinfo = docM.selectByPrimaryKey(id);
        return docinfo;
    }

    @Override
    public scheduleinfo getsche(doctorinfo dinfo) {
        scheduleinfo sch=schM.selectByPrimaryKey(dinfo.getDoctorid());
        return sch;
    }

    @Override
    public boolean upDoctor(doctorinfo dinfo) {
        int n = docM.updateByPrimaryKey(dinfo);
        if(n == 0)
            return false;
        else
            return true;
    }

    @Override
    public boolean leaveDoctor(docleaveinfo dlinfo) {
        int n = 0;
        if (docM.selectByPrimaryKey(dlinfo.getDoctorid())!=null)
        {
            n = docL.insert(dlinfo);
        }
        if(n == 0)
            return false;
        else
            return  true;
    }

    @Override
    public boolean deleleaveDoctor(docleaveinfo dlinfo) {
        int n = 0;
        n = docL.deleteByPrimaryKey(dlinfo);
        if(n == 0)
            return false;
        else
            return  true;
    }

    @Override
    public docleaveinfo getleaveDoctor(String did) {

        return null;
    }

    @Override
    public List<appointrecord> getappoint(String docid) {
        List<appointrecord> app=appdM.selectpa(docid);
        return app;
    }

    @Override
    public appointrecord appointAffirm(String did) {
        appointrecord apps=appdM.selectByPrimaryKey(did);
        return apps;
    }


    @Override
    public boolean setappointAffirm(visitrecord vis) {
        int n=visM.insert(vis);
        appdM.deleteByPrimaryKey(vis.getAppointNumber());
        if (n==0)
            return false;
        else
            return true;
    }

    @Override
    public List<visitrecord> getVisitrecord(String aid, String did) {
        return null;
    }

}
