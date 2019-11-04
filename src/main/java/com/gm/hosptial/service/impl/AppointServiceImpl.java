package com.gm.hosptial.service.impl;

import com.gm.hosptial.mapper.appointrecordMapper;
import com.gm.hosptial.mapper.numberinfoMapper;
import com.gm.hosptial.pojo.appointrecord;
import com.gm.hosptial.service.AppointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lkt
 * @create 2019/10/24 8:42
 */
@Service("appointServiceImpl")
public class AppointServiceImpl implements AppointService {

    @Resource(name = "appointrecordMapper")
    private appointrecordMapper appointrecordMapper;
    @Resource(name = "numberinfoMapper")
    private numberinfoMapper numberinfoMapper;
    @Override
    public boolean upnum(int tid) {
        boolean f=false;
        int i=numberinfoMapper.updateByPrimaryKeySelective(tid);
        if (i==1)
        {
            f=true;
        }
        return f;
    }

    /**
     * 插入预约信息
     * @param appointrecord
     * @return
     */
    @Override
    public boolean insertappoint( appointrecord appointrecord) {
        boolean boolen=false;

        int j=appointrecordMapper.insertSelective(appointrecord);
        if ( j==1)
        {
            boolen=true;
        }
        return boolen;
    }

    @Override
    public appointrecord select(String patientid) {
        appointrecord appointrecord=appointrecordMapper.selectByPrimaryKey(patientid);
        return appointrecord;
    }

    @Override
    public boolean upappointrecord( appointrecord appointrecord) {
        boolean bool=false;
        appointrecord appointrecord1=appointrecordMapper.selectByPrimaryKey(appointrecord.getPatientid());
        if (appointrecord1!=null)
        {
            int i,j;
            j=appointrecordMapper.updateByPrimaryKeySelective(appointrecord);
            if(j==1)
            {
                bool=true;
            }

        }
        return bool;
    }

    @Override
    public boolean deappointrecord(String patientid) {
        boolean f=false;

        appointrecord appointrecord=appointrecordMapper.selectByPrimaryKey(patientid);
        if ( appointrecord!=null)
        {
            int i,j;

            j=appointrecordMapper.deleteByPrimaryKey(patientid);
            if(j==1)
            {
                f=true;
            }

        }
        return f;
    }

    /**
     * 查询预约号
     *
     * @param doctorid
     * @return
     */
    @Override
    public int countnum(String doctorid) {
        int i=appointrecordMapper.count(doctorid);
        return i;
    }
}
