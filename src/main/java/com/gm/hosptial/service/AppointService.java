package com.gm.hosptial.service;

import com.gm.hosptial.pojo.appointinfo;
import com.gm.hosptial.pojo.appointrecord;

public interface AppointService {
    /**
     * 插入预约信息
     * @param appointinfo
     * @param appointrecord
     * @return
     */
    public boolean insertappoint(appointinfo appointinfo, appointrecord appointrecord);

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
}
