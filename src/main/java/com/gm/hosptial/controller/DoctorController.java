package com.gm.hosptial.controller;

import com.gm.hosptial.pojo.*;
import com.gm.hosptial.service.AdminService;
import com.gm.hosptial.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    public String Dpainfo(){//获得患者队列
        String s="doctor/patientList";
        HttpSession session=request.getSession();
        String docid=(String) session.getAttribute("doctorid");
        List<appointrecord> appd=doctorService.getappoint(docid);
//
        request.setAttribute("palist",appd);
        return s;
    }
    @RequestMapping("myinfo")
    public String MtInfo(){//获得个人信息
        String s="doctor/myInfo";
        HttpSession session=request.getSession();
        session.setAttribute("doctorid","0001");
        String docid=(String)session.getAttribute("doctorid");
        System.out.println(docid);
        doctorinfo doc=doctorService.getDoctor(docid);
        departmentinfo dep=adminService.getdepaDrtment(doc.getDoctordeptid());
        session.setAttribute("doctor",doc);
        session.setAttribute("depment",dep);
        return s;
    }
    @RequestMapping("myWork")
    public String DWork(){//获得工作表
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
    @RequestMapping("myPwd")//修改密码
    public String myPwd(String jmm,String xmm,String qdmm){
        String s="doctor/myInfo";
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
    @RequestMapping("DocL")//获取个人请假记录
    public String Docleave(){
        String s="doctor/myApply";
        HttpSession session=request.getSession();
        session.setAttribute("doctorid","0001");
        String docid=(String)session.getAttribute("doctorid");
        doctorinfo doc=doctorService.getDoctor(docid);
        session.setAttribute("doctor",doc);
        List<docleaveinfo> doclist = adminService.getDocleaveinfo();
        for(docleaveinfo docl:doclist){
            if(!docl.getDoctorid().equals(docid)){
                doclist.remove(docl);
            }
        }
        request.setAttribute("doclist",doclist);
        return s;
    }
    @RequestMapping("UpDoctor")//更新医生信息
    public String upDoctor(String name,String account,String phone){
        String s="doctor/myInfo";
        HttpSession session=request.getSession();
        String docid=(String)session.getAttribute("doctorid");
        doctorinfo doc=doctorService.getDoctor(docid);
        doc.setDoctorname(name);
        doc.setDoctorphone(phone);
        doc.setDoctorspecialty(account);
        doctorService.upDoctor(doc);
        session.setAttribute("doctor",doc);
        return s;

    }
    @RequestMapping("Docapply")//医生请假申请
    public String Docapply(String name,String account,String phone,String tbdoc){
        String s="doctor/myApply";

        HttpSession session=request.getSession();
        doctorinfo doc=(doctorinfo) session.getAttribute("doctor");
        docleaveinfo docls=new docleaveinfo();
        docls.setDoctorid(doc.getDoctorid());
        docls.setFlag(0);
        docls.setLeastatime(Integer.valueOf(name));
        docls.setLeadaynum(Integer.valueOf(account));
        docls.setTbdoctorid(tbdoc);
        docls.setTimestatus(1);

        List<docleaveinfo> doclist = adminService.getDocleaveinfo();
        int num=0;
        for(docleaveinfo docl:doclist){
            if(docl.getDoctorid().equals(doc.getDoctorid())){
                if(docl.getFlag()==0){
                    num=1;
                    break;
                }
            }
        }
        if (num==0) {
            if(doctorService.leaveDoctor(docls))
                System.out.println("ok");
        }
        doclist = adminService.getDocleaveinfo();
        for(docleaveinfo docl:doclist){
            if(!docl.getDoctorid().equals(doc.getDoctorid())){
                doclist.remove(docl);
            }
        }

        request.setAttribute("doclist",doclist);
        return s;
    }
    @RequestMapping("Docapplydel")//取消未审批请假申请
    public String Docapplydelete(String did,String ltime,String lnum,String tbdoc){
    String s="doctor/myApply";
    docleaveinfo doclnfo=new docleaveinfo();
    doclnfo.setTbdoctorid(tbdoc);
    doclnfo.setDoctorid(did);
    doclnfo.setLeadaynum(Integer.valueOf(lnum));
    doclnfo.setLeastatime(Integer.valueOf(ltime));
    doclnfo.setFlag(0);
    doclnfo.setTimestatus(1);
    doctorService.deleleaveDoctor(doclnfo);
    List<docleaveinfo> doclist = adminService.getDocleaveinfo();
        for(docleaveinfo docl:doclist){
            if(!docl.getDoctorid().equals(did)){
                doclist.remove(docl);
            }
        }
        request.setAttribute("doclist",doclist);
    return s;
    }
    @RequestMapping("paSave")
    public String paSave(String Recipe,String appointnumber){

        HttpSession session=request.getSession();
        doctorinfo doc=(doctorinfo) session.getAttribute("doctor");
        visitrecord vis=new visitrecord();
        appointrecord appd=doctorService.appointAffirm(appointnumber);
        vis.setRecipe(Recipe);
        vis.setDoctorid(appd.getDoctorid());
        vis.setPatientid(appd.getPatientid());
        vis.setAppointNumber(appd.getAppointnumber());
        vis.setVisitstatus(appd.getAppointtime());
        doctorService.setappointAffirm(vis);
        String s=Dpainfo();
        return s;
    }
}
