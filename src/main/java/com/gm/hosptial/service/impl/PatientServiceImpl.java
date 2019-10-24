package com.gm.hosptial.service.impl;

import com.gm.hosptial.mapper.LoginMapper;
import com.gm.hosptial.mapper.idinfoMapper;
import com.gm.hosptial.mapper.patientinfoMapper;
import com.gm.hosptial.pojo.idinfo;
import com.gm.hosptial.pojo.patientinfo;

import com.gm.hosptial.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author lkt
 * @create 2019/10/22 19:01
 */
@Service("patientServiceImpl")
public class PatientServiceImpl implements PatientService {

//    @Resource(name = "loginMapper")
//    private LoginMapper loginMapper;

    @Resource(name = "patientinfoMapper")
    private patientinfoMapper patientinfoMapper;
    @Resource(name ="idinfoMapper" )
    private idinfoMapper idinfoMapper;

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
        patientinfo patientinfo1=new patientinfo("188","ll","18750382729","男",1,"352203199710163713","123456");
       idinfo idinfo=new idinfo(patientinfo1.getId(),patientinfo1.getPatientname(),"fj");
        idinfo idinfo1=new idinfo();
        idinfo1=idinfoMapper.selectByPrimaryKey("123456");
        if (idinfo1==null)
        {
            idinfoMapper.insert(idinfo);
            patientinfoMapper.insert(patientinfo1);
        }
        else if (idinfo1!=null)
        {
            System.out.println("error!");
        }

        return false;
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
        int i=patientinfoMapper.updateByPrimaryKeySelective(patientinfo);
        return false;
    }

}
