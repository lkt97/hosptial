package com.gm.hosptial.service;

import com.gm.hosptial.pojo.appointinfo;
import com.gm.hosptial.pojo.appointrecord;

import java.util.List;

public interface AppointService {
    /**
     * 插入预约信息

     * @param appointrecord
     * @return
     */
    public boolean insertappoint(appointrecord appointrecord);

    /**
     * 查询信息
     * @param patientid
     * @return
     */
    public appointrecord select(String patientid);

    /**
     * 修改预约信息
     * @param appointinfo
     * @param appointrecord
     * @return
     */
    public boolean upappointrecord(appointinfo appointinfo,appointrecord appointrecord);

    /**
     * 删除预约信息
     * @param patients
     * @return
     */
    public boolean deappointrecord(String patientid);

    /**
     * 查询预约号
     * @param doctor
     * @return
     */
    public int countnum(String doctor);

    public boolean upnum(int tid);

}
