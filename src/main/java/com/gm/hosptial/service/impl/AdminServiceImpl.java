package com.gm.hosptial.service.impl;

import com.gm.hosptial.pojo.*;
import com.gm.hosptial.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {


    @Override
    public boolean addepaDrtment(departmentinfo dep) {
        return false;
    }

    @Override
    public boolean addDoctor(doctorinfo dinfo, String id) {
        return false;
    }

    @Override
    public boolean deleteDoctor(String did) {
        return false;
    }

    @Override
    public boolean upDoctor(doctorinfo did) {
        return false;
    }

    @Override
    public scheduleinfo getScheduleinfo(String did) {
        return null;
    }

    @Override
    public boolean setDepartment(doctorinfo dinfo, scheduleinfo sinfo) {
        return false;
    }

    @Override
    public List<patientinfo> getPatientinfo() {
        return null;
    }

    @Override
    public List<doctorinfo> getDoctorinfo() {
        return null;
    }

    @Override
    public boolean setPatientinfotime(patientinfo pinfo, String time) {
        return false;
    }

    @Override
    public List<docleaveinfo> getDocleaveinfo() {
        return null;
    }

    @Override
    public boolean setDocleaveinfo(docleaveinfo docl) {
        return false;
    }
}
