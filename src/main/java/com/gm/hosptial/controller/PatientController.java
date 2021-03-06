package com.gm.hosptial.controller;

import com.gm.hosptial.pojo.*;
import com.gm.hosptial.service.AppointService;
import com.gm.hosptial.service.DoctorService;
import com.gm.hosptial.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Resource(name = "appointServiceImpl")
    private AppointService appointService;
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @RequestMapping("register")
    public void PRegister(String account,String name,String password,String email,HttpServletResponse response) throws IOException {

        String s="";
        patientinfo patientinfo = new patientinfo();
        patientinfo.setPatientname(name);
        patientinfo.setPatientid(account);
        patientinfo.setPassword(password);
        patientinfo.setPatientphone(email);
        boolean f=patientService.register(patientinfo);

        if (f==true) {

            s= "login";
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type","text/html;charset=utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.sendRedirect("login.jsp");
        }
        else {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type","text/html;charset=utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>alert('注册失败');window.location.href='register.jsp'</script>");
        }

    }

    @RequestMapping("login")
    public void PLogin(String account, String password, Model model,HttpServletResponse response) throws IOException {
        String s="404";
        session=request.getSession();
        patientinfo patientinfo=patientService.Login(account,password);
            if (patientinfo!=null)
            {
                session.setAttribute("patient",patientinfo);
                s="index";

                response.setCharacterEncoding("UTF-8");
                response.setHeader("content-type","text/html;charset=utf-8");
                response.setContentType("text/html;charset=utf-8");
                response.sendRedirect("index.jsp");
//                PrintWriter out=response.getWriter();
//                out.print("<script language='javascript'>alert('"+str+"');window.location.href='"+str2+"'</script>");
            }
            else{
                response.setCharacterEncoding("UTF-8");
                response.setHeader("content-type","text/html;charset=utf-8");
                response.setContentType("text/html;charset=utf-8");

                PrintWriter out=response.getWriter();
                out.print("<script language='javascript'>alert('登录失败');window.location.href='login.jsp'</script>");
            }

//        else if (type.equals("d")){
//            doctorinfo doc=doctorService.getDoctor(account);
//            if (doc!=null&&doc.getDocpassword().equals(password)){
//                s="";
//            }
//
//        }
//        else if (type.equals("g"))
//        {
//            doctorinfo doc=doctorService.getDoctor(account);
//            if (doc!=null&&doc.getDocpassword().equals(password)&&doc.getDoctorjobtitle().equals("主任")){
//                s="";
//            }
//        }

    }

    @RequestMapping("findPwd")
    public String PFpsw(String account,String email,String password)
    {
        String s="";
        patientinfo patientinfo = new patientinfo();
        patientinfo.setPatientid(account);
        patientinfo.setPassword(password);
        patientinfo.setPatientphone(email);

        boolean f=patientService.upPsw(patientinfo);
        if (f==true)
        {
            s="login";
        }
        else
        {

        }
        return  s;
    }

    @RequestMapping("uppsw")
    public String upPsw()
    {
        String s="";

        return s;
    }

    @ResponseBody
    @RequestMapping(value = "msg")
    public Map<String,Object> msg(HttpServletRequest request, HttpServletResponse response,String pwd) throws IOException {

        Map<String,Object> map=new HashMap<String, Object>();
        patientinfo patientinfo= (com.gm.hosptial.pojo.patientinfo) session.getAttribute("patient");
        String psw=patientinfo.getPassword();
        if (psw==pwd)
        {
            map.put("result",true);
        }
        else{
            map.put("result",false);
        }
        map.put("pwd",psw);
        return map;
    }

    @RequestMapping("modifyPwd")
    public String modifyPwd(String xmm)
    {
       String s="";
        session=request.getSession();
        patientinfo patientinfo= (com.gm.hosptial.pojo.patientinfo) session.getAttribute("patient");
        patientinfo.setPassword(xmm);
        boolean f=patientService.upPsw(patientinfo);
        if (f==true)
        {
            s="login";
        }
        else
        {

        }
       return s;
    }

    @RequestMapping("logout")
    public String Logout()
    {
        String s="";
        session=request.getSession();
        session.removeAttribute("patient");
        session.removeAttribute("doctor");
        session.removeAttribute("admin");
        return "index";
    }

    @RequestMapping("searchOffice")
    public String searchOffice(String office)
    {
        Integer currentPage = request.getParameter("currentPage") == null ? 1 : Integer.parseInt(request.getParameter("currentPage"));
        Integer pageSize = request.getParameter("pageSize") == null ? 8 : Integer.parseInt(request.getParameter("pageSize"));
        String s="";

        Page page=new Page();
        if (office!=null)
        {
            page.setOffice(office);
        }
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        Integer beginIndex = (currentPage - 1) * pageSize;
        page.setBeginIndex(beginIndex);
        List<departmentinfo> departments=patientService.searchde(page);
        int i=patientService.countde(page);

        Page page1=new Page(i,currentPage,pageSize,departments);
        System.out.println(page1);
        request.setAttribute("page",page1);
        return "orderOffice";
    }

    @RequestMapping("searchDoctor")
    public String searchDoctor(String office,String doctor)
    {
        Integer currentPage = request.getParameter("currentPage") == null ? 1 : Integer.parseInt(request.getParameter("currentPage"));
        Integer pageSize = request.getParameter("pageSize") == null ? 6: Integer.parseInt(request.getParameter("pageSize"));
        String s="";
        Page page=new Page();
        if (doctor!=null)
        {
            page.setDoctor(doctor);
        }
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        Integer beginIndex = (currentPage - 1) * pageSize;
        page.setBeginIndex(beginIndex);
        page.setOffice(office);
        List<doctorinfo> doctors=patientService.searchdo(page);
        int i=patientService.countdo(page);

        Page page1=new Page(i,currentPage,pageSize,doctors);
        System.out.println(page1);
        request.setAttribute("page",page1);
        return "orderDoctor";

    }

    @RequestMapping("searchList")
    public String searchList()
    {
        String s="";
        session=request.getSession();
        patientinfo patientinfo= (com.gm.hosptial.pojo.patientinfo) session.getAttribute("patient");
        List<appointrecord> appointrecords=appointService.selectap(patientinfo.getPatientid());
//        doctorinfo doctorinfo=doctorService.getDoctor(appointrecords.getDoctorid());
//        session.setAttribute("doctor",doctorinfo);
        session.setAttribute("record",appointrecords);
        return "orderList";
    }

    public static String dateToWeek(String datetime) {

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        Date date;
        try {
            date = f.parse(datetime);
            cal.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //一周的第几天
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    @RequestMapping("doctorInfo")
    public String doctorInfo(String did,Model model)
    {
        scheduleinfo scheduleinfo=patientService.searchsc(did);
        numberinfo numberinfo=new numberinfo();
        doctorinfo doctorinfo=doctorService.getDoctor(did);
        model.addAttribute("doctor",doctorinfo);
        List<String> week = new ArrayList<>();
        List<String> date = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        for (int i = 1; i <=7; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) +i);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String result = format.format(today);

            date.add(dateToWeek(result));
            week.add(result+"<br>"+dateToWeek(result));
            dates.add(result);
        }

        if (date.get(0).equals("星期日"))
        {
            if (scheduleinfo.getSatam()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("SatAM");
                patientService.updatenum(numberinfo);
            }
            else if (scheduleinfo.getSatpm()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("SatPM");
                patientService.updatenum(numberinfo);
            }
        }
        else if (date.get(0).equals("星期一"))
        {
            if (scheduleinfo.getSunam()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("SunAM");
                patientService.updatenum(numberinfo);
            }
            else if (scheduleinfo.getSunpm()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("SunPM");
                patientService.updatenum(numberinfo);
            }
        }
        else if (date.get(0).equals("星期二"))
        {
            if (scheduleinfo.getMonam()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("MonAM");
                patientService.updatenum(numberinfo);
            }
            else if (scheduleinfo.getMonpm()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("MonPM");
                patientService.updatenum(numberinfo);
            }
        }
        else if (date.get(0).equals("星期三"))
        {
            if (scheduleinfo.getThuram()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("TueAM");
                patientService.updatenum(numberinfo);
            }
            else if (scheduleinfo.getThurpm()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("TuePM");
                patientService.updatenum(numberinfo);
            }
        }
        else if (date.get(0).equals("星期四"))
        {
            if (scheduleinfo.getWedam()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("WedAM");
                patientService.updatenum(numberinfo);
            }
            else if (scheduleinfo.getWedpm()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("WedPM");
                patientService.updatenum(numberinfo);
            }
        }
        else if (date.get(0).equals("星期五"))
        {
            if (scheduleinfo.getTueam()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("ThurAM");
                patientService.updatenum(numberinfo);
            }
            else if (scheduleinfo.getTuepm()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("ThurPM");
                patientService.updatenum(numberinfo);
            }
        }
        else if (date.get(0).equals("星期六"))
        {
            if (scheduleinfo.getFriam()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("FriAM");
                patientService.updatenum(numberinfo);
            }
            else if (scheduleinfo.getFripm()!=0)
            {
                numberinfo.setDoctorid(did);
                numberinfo.setSumnumber(10);
                numberinfo.setNumber("FriPM");
                patientService.updatenum(numberinfo);
            }
        }

        System.out.println(date.get(0));
        model.addAttribute("week",week);
        model.addAttribute("date",date);
        model.addAttribute("dates",dates);
        List<numberinfo> numberinfos=patientService.searchnum(did);
        List<Integer> am=new ArrayList<>();
        List<Integer> pm=new ArrayList<>();

        if (date.get(0).equals("星期日"))
        {
            for (int i=0;i<=6;i++)
            {
                am.add(numberinfos.get(i).getSumnumber());
            }
            for (int i=7;i<=13;i++)
            {
                pm.add(numberinfos.get(i).getSumnumber());
            }
            session.setAttribute("am",am);
            session.setAttribute("pm",pm);
        }
        else if (date.get(0).equals("星期一"))
        {
            for (int i=1;i<=6;i++)
            {
                am.add(numberinfos.get(i).getSumnumber());
            }
            for (int i=8;i<=13;i++)
            {
                pm.add(numberinfos.get(i).getSumnumber());
            }
            am.add(numberinfos.get(0).getSumnumber());
            pm.add(numberinfos.get(7).getSumnumber());
//            session.setAttribute("am",am);
//            session.setAttribute("pm",pm);
            model.addAttribute("am",am);
            model.addAttribute("pm",pm);
        }
        else if (date.get(0).equals("星期二"))
        {
            for (int i=2;i<=6;i++)
            {
                am.add(numberinfos.get(i).getSumnumber());
            }
            for (int i=9;i<=13;i++)
            {
                pm.add(numberinfos.get(i).getSumnumber());
            }
            am.add(numberinfos.get(0).getSumnumber());
            pm.add(numberinfos.get(7).getSumnumber());
            am.add(numberinfos.get(1).getSumnumber());
            pm.add(numberinfos.get(8).getSumnumber());
            model.addAttribute("am",am);
            model.addAttribute("pm",pm);
//            session.setAttribute("am",am);
//            session.setAttribute("pm",pm);
        }
        else if (date.get(0).equals("星期三"))
        {
            for (int i=3;i<=6;i++)
            {
                am.add(numberinfos.get(i).getSumnumber());
            }
            for (int i=10;i<=13;i++)
            {
                pm.add(numberinfos.get(i).getSumnumber());
            }
            am.add(numberinfos.get(0).getSumnumber());
            pm.add(numberinfos.get(7).getSumnumber());
            am.add(numberinfos.get(1).getSumnumber());
            pm.add(numberinfos.get(8).getSumnumber());
            am.add(numberinfos.get(2).getSumnumber());
            pm.add(numberinfos.get(9).getSumnumber());
            model.addAttribute("am",am);
            model.addAttribute("pm",pm);
        }
        else if (date.get(0).equals("星期四"))
        {
            for (int i=4;i<=6;i++)
            {
                am.add(numberinfos.get(i).getSumnumber());
            }
            for (int i=11;i<=13;i++)
            {
                pm.add(numberinfos.get(i).getSumnumber());
            }
            am.add(numberinfos.get(0).getSumnumber());
            pm.add(numberinfos.get(7).getSumnumber());
            am.add(numberinfos.get(1).getSumnumber());
            pm.add(numberinfos.get(8).getSumnumber());
            am.add(numberinfos.get(2).getSumnumber());
            pm.add(numberinfos.get(9).getSumnumber());
            am.add(numberinfos.get(3).getSumnumber());
            pm.add(numberinfos.get(10).getSumnumber());
            session.setAttribute("am",am);
            session.setAttribute("pm",pm);
        }
        else if (date.get(0).equals("星期五"))
        {
            for (int i=5;i<=6;i++)
            {
                am.add(numberinfos.get(i).getSumnumber());
            }
            for (int i=12;i<=13;i++)
            {
                pm.add(numberinfos.get(i).getSumnumber());
            }
            am.add(numberinfos.get(0).getSumnumber());
            pm.add(numberinfos.get(7).getSumnumber());
            am.add(numberinfos.get(1).getSumnumber());
            pm.add(numberinfos.get(8).getSumnumber());
            am.add(numberinfos.get(2).getSumnumber());
            pm.add(numberinfos.get(9).getSumnumber());
            am.add(numberinfos.get(3).getSumnumber());
            pm.add(numberinfos.get(10).getSumnumber());
            am.add(numberinfos.get(4).getSumnumber());
            pm.add(numberinfos.get(11).getSumnumber());
            session.setAttribute("am",am);
            session.setAttribute("pm",pm);
        }
        else if (date.get(0).equals("星期六"))
        {
            for (int i=6;i<=6;i++)
            {
                am.add(numberinfos.get(i).getSumnumber());
            }
            for (int i=13;i<=13;i++)
            {
                pm.add(numberinfos.get(i).getSumnumber());
            }
            am.add(numberinfos.get(0).getSumnumber());
            pm.add(numberinfos.get(7).getSumnumber());
            am.add(numberinfos.get(1).getSumnumber());
            pm.add(numberinfos.get(8).getSumnumber());
            am.add(numberinfos.get(2).getSumnumber());
            pm.add(numberinfos.get(9).getSumnumber());
            am.add(numberinfos.get(3).getSumnumber());
            pm.add(numberinfos.get(10).getSumnumber());
            am.add(numberinfos.get(4).getSumnumber());
            pm.add(numberinfos.get(11).getSumnumber());
            am.add(numberinfos.get(5).getSumnumber());
            pm.add(numberinfos.get(12).getSumnumber());
            session.setAttribute("am",am);
            session.setAttribute("pm",pm);
        }

        return "doctorInfo";
    }

    @RequestMapping("order")
    public void order(String data,String week,String am,String did,HttpServletResponse response) throws IOException {
        System.out.println(did);
        session=request.getSession();
        patientinfo patientinfo= (com.gm.hosptial.pojo.patientinfo) session.getAttribute("patient");
        int i=appointService.countnum(did)+1;
        String j="";
        String string=i+"";
        String str2="/doctorInfo.do?did="+did+"";
        String s1=data.replace("-","");
        appointrecord appointrecord1=new appointrecord(s1+patientinfo.getPatientid()+did,patientinfo.getPatientid(),data,"未就诊",string,did);
        if (week.equals("星期日"))
        {
            if (am.equals("上午"))
            {
                j="SunAM";
            }else if (am.equals("下午"))
            {
                j="SunPM";
            }
        }
        else if (week.equals("星期一"))
        {
            if (am.equals("上午"))
            {
                j="MonAM";
            }else if (am.equals("下午"))
            {
                j="MonPM";
            }
        }
        else if (week.equals("星期二"))
        {
            if (am.equals("上午"))
            {
                j="TueAM";
            }else if (am.equals("下午"))
            {
                j="TuePM";
            }
        }
        else if (week.equals("星期三"))
        {
            if (am.equals("上午"))
            {
                j="WedAM";
            }else if (am.equals("下午"))
            {
                j="WedPM";
            }
        }
        else if (week.equals("星期四"))
        {
            if (am.equals("上午"))
            {
                j="ThurAM";
            }else if (am.equals("下午"))
            {
                j="ThurPM";
            }
        }
        else if (week.equals("星期五"))
        {
            if (am.equals("上午"))
            {
                j="FriAM";
            }else if (am.equals("下午"))
            {
                j="FriPM";
            }
        }
        else if (week.equals("星期六"))
        {
            if (am.equals("上午"))
            {
                j="SatAM";
            }else if (am.equals("下午"))
            {
                j="SatPM";
            }
        }
        appointrecord1.setDay(j);
        appointrecord appointrecord=appointService.select(s1+patientinfo.getPatientid()+did);
        if (appointrecord==null)
        {
            boolean f=appointService.insertappoint(appointrecord1);
            numberinfo numberinfo=new numberinfo();
            numberinfo.setDoctorid(did);
            numberinfo.setNumber(j);
            boolean b=appointService.upnum(numberinfo);
            if(f==true)
            {
                String str="您已成功预约:"+data+"的"+i+"号";

                response.setCharacterEncoding("UTF-8");
                response.setHeader("content-type","text/html;charset=utf-8");
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out=response.getWriter();
                out.print("<script language='javascript'>alert('"+str+"');window.location.href='"+str2+"'</script>");
            }
            else {
                response.setCharacterEncoding("UTF-8");
                response.setHeader("content-type","text/html;charset=utf-8");
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out=response.getWriter();
                out.print("<script language='javascript'>alert('预约失败');window.location.href='"+str2+"'</script>");
            }
        }
        else{
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type","text/html;charset=utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>alert('已预约过该医生');window.location.href='"+str2+"'</script>");
        }



    }
    @RequestMapping("Cancelorder")
    public void Cancelorder(String aid,HttpServletResponse response) throws IOException {
        appointrecord appointrecord=appointService.select(aid);
        numberinfo numberinfo=new numberinfo();
        numberinfo.setDoctorid(appointrecord.getDoctorid());
        numberinfo.setNumber(appointrecord.getDay());
        boolean f=appointService.deappointrecord(appointrecord.getAppointnumber());
        boolean b=appointService.upnum1(numberinfo);
        if (f==true && b==true)
        {
            String s="/searchList.do";
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type","text/html;charset=utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>alert('取消成功');window.location.href='"+s+"'</script>");
        }
        else {
            String s="/searchList.do";
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-type","text/html;charset=utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print("<script language='javascript'>alert('取消失败');window.location.href='"+s+"'</script>");
        }

    }

}
