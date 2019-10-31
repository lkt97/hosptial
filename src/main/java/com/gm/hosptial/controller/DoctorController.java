package com.gm.hosptial.controller;

import com.gm.hosptial.pojo.*;
import com.gm.hosptial.service.AdminService;
import com.gm.hosptial.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anliqin
 * @create 2019/10/30 9:52
 */
@Controller
public class DoctorController {
    @Resource(name = "doctorServiceImpl")
    private DoctorService doctorService;
    @Resource(name = "adminServiceImpl")
    private AdminService adminService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("palist")
    public String Dpainfo(){
        String s="";
        HttpSession session=request.getSession();
        String docid=(String) session.getAttribute("doctorid");
        List<appointinfo> app=doctorService.getappoint(docid);
        List<appoint> pa=new ArrayList<appoint>();
        for (appointinfo apps:app){
            appointrecord appd=doctorService.appointAffirm(apps.getPatientid());
            appoint appoints=new appoint(apps.getPatientid(),appd.getDoctorid(),apps.getHao(),appd.getNumber(),
                    appd.getAppointnumber(),appd.getAppointtime(),appd.getAppointstatus());
            pa.add(appoints);
        }
        return s;
    }
    @RequestMapping("myinfo")
    public String MtInfo(){
        String s="doctor/myInfo";
        HttpSession session=request.getSession();
        session.setAttribute("doctorid","0001");
        String docid=(String)session.getAttribute("doctorid");
        System.out.println(docid);
        doctorinfo doc=doctorService.getDoctor(docid);
        session.setAttribute("doctor",doc);
        return s;
    }
    @RequestMapping("myWork")
    public String DWork(){
        String s="doctor/myWork";
        HttpSession session=request.getSession();
        session.setAttribute("doctorid","0001");
        String docid=(String)session.getAttribute("doctorid");
        System.out.println(docid);
        doctorinfo doc=doctorService.getDoctor(docid);
        session.setAttribute("doctor",doc);
        scheduleinfo sch=doctorService.getsche(doc);
        session.setAttribute("doctorsch",sch);
        System.out.println(sch.getSatpm());
        return s;
    }
    @RequestMapping("myPwd")
    public String myPwd(String jmm,String xmm,String qdmm){
        String s="doctor/modifyPwd";
        HttpSession session=request.getSession();
        session.setAttribute("doctorid","0001");
        String docid=(String)session.getAttribute("doctorid");
        if(xmm.equals(qdmm)){
            doctorinfo doc=doctorService.getDoctor(docid);
            if (doc.getDocpassword().equals(jmm))
            {
                doc.setDocpassword(xmm);
                doctorService.upDoctor(doc);
            }
        }
        return s;
    }
}
