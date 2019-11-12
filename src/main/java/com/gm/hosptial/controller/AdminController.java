package com.gm.hosptial.controller;

import com.gm.hosptial.pojo.*;
import com.gm.hosptial.pojo.doctorinfo;
import com.gm.hosptial.service.AdminService;
import com.gm.hosptial.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {
    @Resource(name = "doctorServiceImpl")
    private DoctorService doctorService;

    @Resource(name = "adminServiceImpl")
    private AdminService adminService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("adminlogin")
    public String adminlogin(String account,String password){
        String s="";
        doctorinfo doc=doctorService.getDoctor(account);
        if (doc.getDocpassword().equals(password)&&doc.getDoctorjobtitle().equals("科室主任")){
            HttpSession session=request.getSession();
            session.setAttribute("adminid",account);
            session.setAttribute("admin",doc);
            s="admin/index";
        }else{
            s="admin/login";
        }
        return s;
    }
    @RequestMapping("index.do")
    public String myinfo(){
        String s="admin/index";
        HttpSession session=request.getSession();
        if(session.getAttribute("adminid")!=null){
        String docid=(String)session.getAttribute("adminid");
        System.out.println(docid);
        doctorinfo doc=doctorService.getDoctor(docid);
        departmentinfo dep=adminService.getdepaDrtment(doc.getDoctordeptid());
        session.setAttribute("admin",doc);
        session.setAttribute("depment",dep);
        }else{
            s="admin/login";
        }
        return s;
    }
    @RequestMapping("Doclist")
    public String Doclist(){
        String s="admin/doctorManage";
        HttpSession session=request.getSession();
        if(session.getAttribute("adminid")!=null){
        String docid=(String)session.getAttribute("adminid");
        doctorinfo doczr=doctorService.getDoctor(docid);
        departmentinfo dep=adminService.getdepaDrtment(doczr.getDoctordeptid());
        session.setAttribute("depment",dep);
        List<doctorinfo> doclist=adminService.getDoctorinfo();
        for(doctorinfo doc:doclist){
            if (!doc.getDoctordeptid().equals(doczr.getDoctordeptid())){
                doclist.remove(doc);
            }
        }

        request.setAttribute("doclist",doclist);
        }else{
            s="admin/login";
        }
        return s;
    }
    @RequestMapping("registerdoc")
    public String resDoctor(String DoctorID, String DocPassword, String DoctorName,
                            String doctorsex, String doctorage, String DoctorJobTitle, String DoctorSpecialty
            , String DoctorPhone, HttpServletResponse response)throws IOException {
        String s="";
        HttpSession session=request.getSession();
        departmentinfo department=(departmentinfo)session.getAttribute("depment");
        doctorinfo doc=new doctorinfo();
        doc.setDoctorjobtitle(DoctorJobTitle);
        doc.setDocpassword(DocPassword);
        doc.setDoctordeptid(department.getDepartmentid());
        doc.setDoctorid(DoctorID);
        doc.setDoctorphone(DoctorPhone);
        doc.setDoctorname(DoctorName);
        doc.setDoctorage(doctorage);
        doc.setDoctorsex(doctorsex);
        doc.setDoctorstatus(1);
        doc.setDoctorspecialty(DoctorSpecialty);
        if(doctorService.getDoctor(doc.getDoctorid())==null){
                boolean bo=adminService.addDoctor(doc);
                if (bo==true){
                String doctorid=doc.getDoctorid();
                scheduleinfo sche=new scheduleinfo(doc.getDoctorid(),doc.getDoctordeptid()
                        ,0,0,0,0,0,0,0
                        ,0,0,0,0,0,0,0);
                adminService.setDepartment(sche);
                numberinfo number=new numberinfo(doctorid,"SunAM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"MonAM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"TueAM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"WedAM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"ThurAM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"FriAM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"SatAM",0);
                adminService.setNumber(number);

                number=new numberinfo(doctorid,"SunPM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"MonPM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"TuePM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"WedPM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"ThurPM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"FriPM",0);
                adminService.setNumber(number);
                number=new numberinfo(doctorid,"SatPM",0);
                adminService.setNumber(number);
            }
                String str2="/Doclist.do";
                    response.setCharacterEncoding("UTF-8");
                    response.setHeader("content-type","text/html;charset=utf-8");
                    response.setContentType("text/html;charset=utf-8");
                    PrintWriter out=response.getWriter();
                    out.print("<script language='javascript'>alert('增加成功');window.location.href='"+str2+"'</script>");

        }
        return Doclist();
    }
    @RequestMapping("paAllList")
    public String paAllList(String currentPage,String pageSize){
        String s="admin/patientManage";
        HttpSession session=request.getSession();
        if (session.getAttribute("adminid") != null) {
            String docid=(String)session.getAttribute("adminid");
            doctorinfo doczr=doctorService.getDoctor(docid);
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
            int totalRecords =adminService.gcountPatientinfo();
            List<patientinfo> palist=adminService.getPatientinfo(page);
            Page repage=new Page(totalRecords,currentPages,pageSizes,palist);
            System.out.println(palist);
            request.setAttribute("page",repage);
        }else{
            s="admin/login";
        }
        return s;
    }
    @RequestMapping("findoc")
    public String Finddoc(String doctor){
        String s="admin/doctorManage";
        HttpSession session=request.getSession();
        if(session.getAttribute("adminid")!=null){
            String docid=(String)session.getAttribute("adminid");
            doctorinfo doczr=doctorService.getDoctor(docid);
            departmentinfo dep=adminService.getdepaDrtment(doczr.getDoctordeptid());
            doctorinfo doc=new doctorinfo();
            doc.setDoctorname(doctor);
            List<doctorinfo> doclist=adminService.getDoctorinfos(doc);

            request.setAttribute("doclist",doclist);
        }else{
            s="admin/login";
        }
        return s;
    }
    @RequestMapping("docLlist")
    public String docLlist(String currentPage,String pageSize){
        String s="admin/applyManage";
        HttpSession session=request.getSession();
        if (session.getAttribute("adminid") != null) {
            String docid=(String)session.getAttribute("adminid");
            doctorinfo doczr=doctorService.getDoctor(docid);
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
            page.setOffice(doczr.getDoctordeptid());
            int totalRecords =adminService.gcountPatientinfo();
            List<docleaveinfo> palist=adminService.getDocleaveinfo(page);
            Page repage=new Page(totalRecords,currentPages,pageSizes,palist);
            System.out.println(palist);
            List<departmentinfo> deplist=officename();
            request.setAttribute("page",repage);
            request.setAttribute("data",deplist);
        }else{
            s="admin/login";
        }
        return s;
    }
    @RequestMapping("office")
    public String office(String currentPage,String pageSize){
        String s="admin/office";

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
        List<departmentinfo> deplist=new ArrayList<departmentinfo>();
        HttpSession session=request.getSession();
        if (session.getAttribute("adminid") != null){
        deplist=adminService.getdepaDrtmentlist(page);}
        else{
            s="admin/login";
        }
        int totalRecords =adminService.countdepaDrtment();
        Page repage=new Page(totalRecords,currentPages,pageSizes,deplist);
        request.setAttribute("page",repage);
        return s;
    }
    @RequestMapping("Foffice")
    public String Foffice(String office){
        String s="admin/office";
        departmentinfo dep=adminService.getdepaDrtmenttwo(office);
        List<departmentinfo> deplist=new ArrayList<departmentinfo>();
        deplist.add(dep);
        Page repage=new Page(1,1,1,deplist);
        request.setAttribute("page",repage);

        return s;
    }
    @RequestMapping("addOffice")
    public String addOffice(String officeid,String officename,String description){
        HttpSession session=request.getSession();
        if (session.getAttribute("adminid") != null){
        departmentinfo dep=new departmentinfo();
        dep.setDepartmentid(officeid);
        dep.setDepartmentname(officename);
        dep.setDepartmentintroduction(description);
        adminService.addepaDrtment(dep);
        doctorinfo doc=new doctorinfo();
        doc.setDoctorname("");
        doc.setDoctorstatus(1);
        doc.setDoctorsex("男");
        doc.setDoctorage("21");
        doc.setDoctorspecialty("");
        doc.setDoctorid(officeid);
        doc.setDocpassword(officeid);
        doc.setDoctorjobtitle("科室主任");
        doc.setDoctordeptid(officeid);
        adminService.addDoctor(doc);
        }
        return office("1","6");
    }
    public List<departmentinfo> officename(){
        Page page=new Page();
        int totalRecords =adminService.countdepaDrtment();
        page.setPageSize(totalRecords);
        page.setCurrentPage(1);
        page.setBeginIndex(0);
        List<departmentinfo> deplist=adminService.getdepaDrtmentlist(page);
        return deplist;
    }
    @RequestMapping("modpwd")
    public String modpwd(){
        String s="admin/modifyPwd";
        return s;
    }
    @RequestMapping("doclSave")
    public String doclSave(String dleid){
        docleaveinfo docl=new docleaveinfo();
        docl.setDleid(Integer.valueOf(dleid));
        adminService.setSaveDocleaveinfo(docl);
        return docLlist("1","6");
    }
    @RequestMapping("doclNo")
    public String doclNo(String dleid){
        docleaveinfo docl=new docleaveinfo();
        docl.setDleid(Integer.valueOf(dleid));
        adminService.setNoDocleaveinfo(docl);
        return docLlist("1","6");
    }
    @RequestMapping("docExit")
    public String docexit(){
        String s="admin/index";

        HttpSession session=request.getSession();
        session.removeAttribute("adminid");
        session.removeAttribute("admin");
        session.removeAttribute("depment");
        return s;
    }
    @RequestMapping("schedule")
    public String schedule(String doctorid){
        String s="admin/scheduleManage";
        doctorinfo doctor=doctorService.getDoctor(doctorid);
        scheduleinfo sche;
        sche=adminService.getScheduleinfo(doctorid);
        if (sche==null) {
            sche=new scheduleinfo(doctor.getDoctorid(),doctor.getDoctordeptid()
            ,0,0,0,0,0,0,0
                    ,0,0,0,0,0,0,0);
            adminService.setDepartment(sche);
        }

        request.setAttribute("sche",sche);
        request.setAttribute("doctors",doctor);
        return s;
    }
    @RequestMapping("scheUp")
    public String scheUp(String doctorid, String departmentname
            , Integer sunam, Integer monam, Integer tueam, Integer wedam
            , Integer thuram, Integer friam, Integer satam, Integer sunpm
            , Integer monpm, Integer tuepm, Integer wedpm, Integer thurpm
            , Integer fripm, Integer satpm){
        String s="";
        String arr1[]={"SunAM","MonAM","TueAM","WedAM","ThurAM","FriAM","SatAM"};
        String arr2[]={"SunPM","MonPM","TuePM","WedPM","ThurPM","FriPM","SatPM"};
        scheduleinfo sche=new scheduleinfo(doctorid,departmentname,sunam,monam,tueam,wedam,
                thuram,friam,satam,sunpm,monpm,tuepm,wedpm,thurpm,fripm,satpm);
        adminService.setDepartment(sche);
        numberinfo number=new numberinfo(doctorid,"SunAM",sunam);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"MonAM",monam);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"TueAM",tueam);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"WedAM",wedam);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"ThurAM",thuram);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"FriAM",friam);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"SatAM",satam);
        adminService.setNumber(number);

        number=new numberinfo(doctorid,"SunPM",sunpm);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"MonPM",monpm);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"TuePM",tuepm);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"WedPM",wedpm);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"ThurPM",thurpm);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"FriPM",fripm);
        adminService.setNumber(number);
        number=new numberinfo(doctorid,"SatPM",satpm);
        adminService.setNumber(number);
        return schedule(doctorid);
    }
    @RequestMapping("adminPwd")//修改密码
    public String myPwd(String jmm,String xmm,String qdmm){
        String s="admin/index";
        HttpSession session=request.getSession();

        if( session.getAttribute("adminid")!=null||session.getAttribute("admin")!=null){
            String docid=(String)session.getAttribute("adminid");
            if(xmm.equals(qdmm)){
                doctorinfo doc=doctorService.getDoctor(docid);
                if (doc.getDocpassword().equals(jmm))
                {
                    doc.setDocpassword(xmm);
                    doctorService.upDoctor(doc);
                }
            }
        }else{
            s="admin/login";
        }
        return s;
    }
    @RequestMapping("adminup")
    public String adminup(String DoctorName,String doctorage,String DoctorPhone,String doctorsex,String DoctorSpecialty){
        String s="";
        HttpSession session=request.getSession();
        if (session.getAttribute("admin")!=null){
            doctorinfo admin=(doctorinfo) session.getAttribute("admin");
            admin.setDoctorname(DoctorName);
            admin.setDoctorage(doctorage);
            admin.setDoctorphone(DoctorPhone);
            admin.setDoctorsex(doctorsex);
            admin.setDoctorspecialty(DoctorSpecialty);
            doctorService.upDoctor(admin);
        }
        return myinfo();
    }
}
