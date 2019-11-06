package com.gm.hosptial.service.impl;

import com.gm.hosptial.mapper.*;
import com.gm.hosptial.pojo.*;

import com.gm.hosptial.service.PatientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lkt
 * @create 2019/10/22 19:01
 */
@Service("patientServiceImpl")
public class PatientServiceImpl implements PatientService {

    @Resource(name = "docleaveinfoMapper")
    private docleaveinfoMapper docleaveinfoMapper;
    @Resource(name = "patientinfoMapper")
    private patientinfoMapper patientinfoMapper;
    @Resource(name = "departmentinfoMapper")
    private departmentinfoMapper departmentinfoMapper;
    @Resource(name = "doctorinfoMapper")
    private doctorinfoMapper doctorinfoMapper;
    @Resource(name = "scheduleinfoMapper")
    private scheduleinfoMapper scheduleinfoMapper;
    @Resource(name = "numberinfoMapper")
    private numberinfoMapper numberinfoMapper;


    /**
     * 患者登录
     * @param patientid
     * @param password
     * @return
     */
    @Override
    public patientinfo Login(String patientid, String password) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("patientid",patientid);
        map.put("password",password);
        System.out.println(map);
        patientinfo patientinfo =patientinfoMapper.login(map);
        return patientinfo;
    }

    /***
     * 患者注册
     * @param patientinfo
     * @return
     */
    @Override
    public boolean register(patientinfo patientinfo) {

        boolean f=false;
        patientinfo patientinfo1=patientinfoMapper.selectByPrimaryKey(patientinfo.getPatientid());
        if (patientinfo1==null)
        {

            int i=patientinfoMapper.insertSelective(patientinfo);

            f=true;
        }
        else if (patientinfo1!=null)
        {
           f=false;
        }

        return f;
    }

    /**
     * 更新患者资料
     * 修改密码
     * @param patientinfo
     * @return
     */
    @Override
    public boolean updatePatient(patientinfo patientinfo) {
        int i=patientinfoMapper.updateByPrimaryKeySelective(patientinfo);
        System.out.println(i);
        return true;
    }

    /**
     * 修改密码
     * @param patientinfo
     * @return
     */
    @Override
    public boolean upPsw(patientinfo patientinfo) {
        boolean f=false;
        int i=patientinfoMapper.updateByPrimaryKeySelective(patientinfo);
        if (i==1)
        {
            f=true;
        }
        return f;
    }

    @Override
    public List<departmentinfo> searchde(Page page) {


        List<departmentinfo> departments=departmentinfoMapper.select(page);
        return departments;

    }

    @Override
    public int countde() {
        int i=0;
        i=departmentinfoMapper.count();
        return i;
    }

    @Override
    public List<doctorinfo> searchdo(Page page) {

        List<doctorinfo> doctors=doctorinfoMapper.selectp(page);



        return doctors;
    }

    @Override
    public int countdo(Page page) {
        int i=0;
        i=doctorinfoMapper.count(page);
        return i;
    }

    @Override
    public scheduleinfo searchsc(String doctorid) {
        scheduleinfo list= scheduleinfoMapper.selectByPrimaryKey(doctorid);
        return list;
    }

    /**
     * 查询号源
     *
     * @param doctorid
     * @return
     */
    @Override
    public List<numberinfo> searchnum(String doctorid) {
        List<numberinfo> list=numberinfoMapper.select(doctorid);
        return list;
    }


}
