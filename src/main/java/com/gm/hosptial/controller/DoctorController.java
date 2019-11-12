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
    @RequestMapping("doclogin")
    public String doclogin(String account,String password){
        String s="";
        doctorinfo doc=doctorService.getDoctor(account);
        if (doc.getDocpassword().equals(password)&&doc.getDoctorjobtitle().equals("医生")){
            HttpSession session=request.getSession();
            session.setAttribute("doctorid",account);
            session.setAttribute("doctor",doc);
            s="doctor/index";
        }else{
            s="doctor/login";
        }
        return s;
    }
    @RequestMapping("docpwd")
    public String docpwd(){
        String s="doctor/modifyPwd";
        return s;
    }
    @RequestMapping("palist")
    public String Dpainfo(String currentPage,String pageSize){//获得患者队列
        String s="doctor/patientList";
        HttpSession session=request.getSession();
        if( session.getAttribute("doctorid")!=null){
        String docid=(String) session.getAttribute("doctorid");
        Integer currentPages;
        Integer pageSizes;
        if(currentPage==null)
            currentPages=1;
        else
            currentPages=Integer.valueOf(currentPage);
        if (pageSize==null)
            pageSizes=6;
        else
            pageSizes=Integer.valueOf(pageSize);
        Page page=new Page();
        page.setPageSize(pageSizes);
        page.setCurrentPage(currentPages);
        page.setBeginIndex((currentPages - 1) * pageSizes);
        List<appointrecord> appd=doctorService.getappoint(docid,page);
        int totalRecords =doctorService.appointcount(docid);
        System.out.println(appd);
        Page repage=new Page(totalRecords,currentPages,pageSizes,appd);
        request.setAttribute("page",repage);}
        return s;
    }
    @RequestMapping("myinfo")
    public String MtInfo(){//获得个人信息
        String s="doctor/myInfo";
        HttpSession session=request.getSession();
        if( session.getAttribute("doctorid")!=null){
        String docid=(String)session.getAttribute("doctorid");
        doctorinfo doc=doctorService.getDoctor(docid);
        departmentinfo dep=adminService.getdepaDrtment(doc.getDoctordeptid());
        session.setAttribute("doctor",doc);
        session.setAttribute("depment",dep);
        }
        return s;
    }
    @RequestMapping("myWork")
    public String DWork(){//获得工作表
        String s="doctor/myWork";
        HttpSession session=request.getSession();
        if( session.getAttribute("doctorid")!=null){
        String docid=(String)session.getAttribute("doctorid");
        doctorinfo doc=doctorService.getDoctor(docid);
        session.setAttribute("doctor",doc);
        scheduleinfo sch=doctorService.getsche(doc);
        session.setAttribute("doctorsch",sch);
        }
        return s;
    }
    @RequestMapping("myPwd")//修改密码
    public String myPwd(String jmm,String xmm,String qdmm){
        String s="doctor/myInfo";
        HttpSession session=request.getSession();

        if( session.getAttribute("doctorid")!=null||session.getAttribute("doctor")!=null){
        String docid=(String)session.getAttribute("doctorid");
        if(xmm.equals(qdmm)){
            doctorinfo doc=doctorService.getDoctor(docid);
            if (doc.getDocpassword().equals(jmm))
            {
                doc.setDocpassword(xmm);
                doctorService.upDoctor(doc);
            }
        }
        }
        return s;
    }
    @RequestMapping("DocL")//获取个人请假记录
    public String Docleave(String currentPage,String pageSize){
        String s="doctor/myApply";
        HttpSession session=request.getSession();
        if( session.getAttribute("doctorid")!=null) {
            String docid = (String) session.getAttribute("doctorid");
            doctorinfo doc = doctorService.getDoctor(docid);
            session.setAttribute("doctor", doc);
            Integer currentPages;
            Integer pageSizes;
            if (currentPage == null)
                currentPages = 1;
            else
                currentPages = Integer.valueOf(currentPage);
            if (pageSize == null)
                pageSizes = 6;
            else
                pageSizes = Integer.valueOf(pageSize);
            Page page = new Page();
            page.setPageSize(pageSizes);
            page.setCurrentPage(currentPages);
            page.setBeginIndex((currentPages - 1) * pageSizes);
            page.setOffice(docid);
            List<docleaveinfo> doclist = doctorService.getleaveDoctorlis(page);
            System.out.println(doclist);
            int totalRecords = doctorService.countdeleleave(docid);
            Page repage = new Page(totalRecords, currentPages, pageSizes, doclist);
            request.setAttribute("page", repage);
        }
        return s;
    }
    @RequestMapping("UpDoctor")//更新医生信息
    public String upDoctor(String name,String account,String phone,String doctorsex,String doctorage){
        String s="doctor/myInfo";
        HttpSession session=request.getSession();
        if( session.getAttribute("doctorid")!=null){
        String docid=(String)session.getAttribute("doctorid");
        doctorinfo doc=doctorService.getDoctor(docid);
        doc.setDoctorname(name);
        doc.setDoctorphone(phone);
        doc.setDoctorspecialty(account);
        doc.setDoctorage(doctorage);
        doc.setDoctorsex(doctorsex);
        doctorService.upDoctor(doc);
        session.setAttribute("doctor",doc);
        }
        return s;

    }
    @RequestMapping("Docapply")//医生请假申请
    public String Docapply(String name,String account,String phone,String tbdoc){
        String s="doctor/myApply";

        HttpSession session=request.getSession();

        if( session.getAttribute("doctorid")!=null) {
            doctorinfo doc = (doctorinfo) session.getAttribute("doctor");
            docleaveinfo docls = new docleaveinfo();
            docls.setDoctorid(doc.getDoctorid());
            docls.setFlag(0);
            docls.setLeastatime(Integer.valueOf(name));
            docls.setLeadaynum(Integer.valueOf(account));
            docls.setTbdoctorid(tbdoc);
            docls.setTimestatus(1);

            docleaveinfo doclea = doctorService.getleaveDoctor(doc.getDoctorid());

            if (doclea == null) {
                if (doctorService.leaveDoctor(docls))
                    System.out.println("ok");
            }
        }
        return Docleave("1","6");
    }
    @RequestMapping("Docapplydel")//取消未审批请假申请
    public String Docapplydelete(String dleid){
    String s="doctor/myApply";
    docleaveinfo doclnfo=new docleaveinfo();
    doclnfo.setDleid(Integer.valueOf(dleid));
    doctorService.deleleaveDoctor(doclnfo);

    return Docleave("1","6");
    }
    @RequestMapping("paSave")
    public String paSave(String Recipe,String appointnumber){

        HttpSession session=request.getSession();
        if( session.getAttribute("doctorid")!=null){
        doctorinfo doc=(doctorinfo) session.getAttribute("doctor");
        visitrecord vis=new visitrecord();
        appointrecord appd=doctorService.appointAffirm(appointnumber);
        vis.setRecipe(Recipe);
        vis.setDoctorid(appd.getDoctorid());
        vis.setPatientid(appd.getPatientid());
        vis.setAppointNumber(appd.getAppointnumber());
        vis.setVisitstatus(appd.getAppointtime());
        doctorService.setappointAffirm(vis);
        }
        String s=Dpainfo("1","6");
        return s;
    }
    @RequestMapping("pdDel")
    public String paDel(String Recipe,String appointnumber){

        HttpSession session=request.getSession();

        if( session.getAttribute("doctorid")!=null){
        doctorinfo doc=(doctorinfo) session.getAttribute("doctor");
        visitrecord vis=new visitrecord();
        appointrecord appd=doctorService.appointAffirm(appointnumber);
        vis.setRecipe("爽约");
        vis.setDoctorid(appd.getDoctorid());
        vis.setPatientid(appd.getPatientid());
        vis.setAppointNumber(appd.getAppointnumber());
        vis.setVisitstatus(appd.getAppointtime());
        doctorService.setappointAffirm(vis);
        }

        String s=Dpainfo("1","6");
        return s;

    }
    @RequestMapping("dExit")
    public String dexit(){
        String s="doctor/login";

        HttpSession session=request.getSession();
        session.removeAttribute("doctorid");
        session.removeAttribute("doctor");
        session.removeAttribute("depment");
        return s;
    }
}
