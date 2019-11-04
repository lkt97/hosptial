package com.gm.hosptial.service.impl;

import com.gm.hosptial.mapper.appointinfoMapper;
import com.gm.hosptial.mapper.appointrecordMapper;
import com.gm.hosptial.mapper.numberinfoMapper;
import com.gm.hosptial.pojo.appointinfo;
import com.gm.hosptial.pojo.appointrecord;
import com.gm.hosptial.service.AppointService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lkt
 * @create 2019/10/24 8:42
 */
@Service("appointServiceImpl")
public class AppointServiceImpl implements AppointService {

    @Resource(name = "appointinfoMapper")
    private appointinfoMapper appointinfoMapper;

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
    public boolean upappointrecord(appointinfo appointinfo, appointrecord appointrecord) {
        boolean bool=false;
        appointinfo appointinfo1=appointinfoMapper.selectByPrimaryKey(appointinfo.getPatientid());
        appointrecord appointrecord1=appointrecordMapper.selectByPrimaryKey(appointrecord.getPatientid());
        if (appointinfo1!=null && appointrecord1!=null)
        {
            int i,j;
            i=appointinfoMapper.updateByPrimaryKeySelective(appointinfo);
            j=appointrecordMapper.updateByPrimaryKeySelective(appointrecord);
            if(i==1&&j==1)
            {
                bool=true;
            }

        }
        return bool;
    }

    @Override
    public boolean deappointrecord(String patientid) {
        boolean f=false;
        appointinfo appointinfo=appointinfoMapper.selectByPrimaryKey(patientid);
        appointrecord appointrecord=appointrecordMapper.selectByPrimaryKey(patientid);
        if (appointinfo!=null && appointrecord!=null)
        {
            int i,j;
            i=appointinfoMapper.deleteByPrimaryKey(patientid);
            j=appointrecordMapper.deleteByPrimaryKey(patientid);
            if(i==1&&j==1)
            {
                f=true;
            }

        }
        return f;
    }

    /**
     * 查询预约号
     *
     * @param doctor
     * @return
     */
    @Override
    public int countnum(String doctorid) {
        int i=appointrecordMapper.count(doctorid);
        return i;
    }
}
