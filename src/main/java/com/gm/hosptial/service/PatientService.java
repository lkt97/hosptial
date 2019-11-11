package com.gm.hosptial.service;

import com.gm.hosptial.pojo.*;

import java.util.List;

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

    /**
     * 查找部门
     * @return
     */
    public List<departmentinfo> searchde(Page page);

    /**
     * 查询部门数量
     * @return
     */
    public int countde(Page page);

    /**
     * 查找部门
     * @return
     */
    public List<doctorinfo> searchdo(Page page);

    /**
     * 查询部门数量
     * @return
     */
    public int countdo(Page page);

    /**
     * 查询排班信息
     * @param doctorid
     * @return
     */
    public scheduleinfo searchsc(String doctorid);

    /**
     * 查询号源
     * @param doctorid
     * @return
     */
    public List<numberinfo> searchnum(String doctorid);

    /**
     * 更新号源
     * @return
     */
    public boolean updatenum(numberinfo numberinfo);


}
