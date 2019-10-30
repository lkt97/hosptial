package com.gm.hosptial.controller;

import com.gm.hosptial.pojo.doctorinfo;
import com.gm.hosptial.service.AdminService;
import com.gm.hosptial.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
public class AdminController {
    @Resource(name = "doctorServiceImpl")
    private DoctorService doctorService;

    @Resource(name = "adminServiceImpl")
    private AdminService adminService;

    @RequestMapping("registerdoc")
    public String resDoctor(String DoctorID, String DocPassword, String DoctorName, String DoctorDeptID,String DoctorJobTitle,String DoctorSpecialty
    ,String DoctorPhone){
        String s="";
        doctorinfo doc=new doctorinfo();
        doc.setDoctorjobtitle(DoctorJobTitle);
        doc.setDocpassword(DocPassword);
        doc.setDoctordeptid(DoctorDeptID);
        doc.setDoctorid(DoctorID);
        doc.setDoctorphone(DoctorPhone);
        doc.setDoctorname(DoctorName);
        doc.setDoctorspecialty(DoctorSpecialty);
        if(doctorService.getDoctor(doc.getDoctorid())==null){
            if (adminService.getdepaDrtment(doc.getDoctordeptid())!=null)
            {
                boolean bo=adminService.addDoctor(doc);
                if (bo==true)
                    s="";
                else
                    s="";
            }
            else
                s="";
        }
        else
            s="";
        return s;
    }
}
