package com.gm.hosptial.service;

import com.gm.hosptial.pojo.appointrecord;

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
     * @param appointrecord
     * @return
     */
    public boolean upappointrecord(appointrecord appointrecord);

    /**
     * 删除预约信息
     * @param patientid
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
