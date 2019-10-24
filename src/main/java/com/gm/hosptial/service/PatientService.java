package com.gm.hosptial.service;

import com.gm.hosptial.pojo.patientinfo;

public interface PatientService {
    /**
     * 患者登录
     * @param patientid
     * @param password
     * @return
     */
    public patientinfo Login(String patientid,String password);

    /***
     * 患者注册
     * @param patientinfo
     * @return
     */
    public boolean register(patientinfo patientinfo);

    /**
     * 更新患者资料
     * @param patientinfo
     * @return
     */
    public boolean updatePatient(patientinfo patientinfo);

    /**
     * 修改密码
     * @param patientinfo
     * @return
     */
    public boolean upPsw(patientinfo patientinfo);

}
