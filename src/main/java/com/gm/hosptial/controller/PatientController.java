package com.gm.hosptial.controller;

import com.gm.hosptial.pojo.doctorinfo;
import com.gm.hosptial.pojo.patientinfo;
import com.gm.hosptial.service.DoctorService;
import com.gm.hosptial.service.PatientService;
import com.gm.hosptial.service.impl.PatientServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author lkt
 * @create 2019/10/29 9:07
 */
@Controller
public class PatientController {
    @Resource(name = "patientServiceImpl")
    private PatientService patientService;
    @Resource(name = "doctorServiceImpl")
    private DoctorService doctorService;
    @RequestMapping("register")
    public String PRegister(String registerName,String password,String mobile)
    {

        String s="";
        patientinfo patientinfo = new patientinfo();
        patientinfo.setPatientid(registerName);
        patientinfo.setPassword(password);
        patientinfo.setPatientphone(mobile);
        boolean f=patientService.register(patientinfo);

        if (f==true) {

            s= "login";
        }
        return s;
    }

    @RequestMapping("login ")
    public String PLogin(String usename,String password,String type)
    {
        String s="";
        if (type.equals("p"))
        {
        patientinfo patientinfo=patientService.Login(usename,password);
            if (patientinfo!=null)
            {
                s="";
            }
        }
        else if (type.equals("d")){
            doctorinfo doc=doctorService.getDoctor(usename);
            if (doc!=null&&doc.getDocpassword().equals(password)){
                s="";
            }

        }
        else if (type.equals("g"))
        {
            doctorinfo doc=doctorService.getDoctor(usename);
            if (doc!=null&&doc.getDocpassword().equals(password)&&doc.getDoctorjobtitle().equals("主任")){
                s="";
            }
        }
        return s;
    }
}
