package com.gm.hosptial;

import com.gm.hosptial.service.AppointService;
import com.gm.hosptial.service.DoctorService;
import com.gm.hosptial.service.PatientService;

import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author lkt
 * @create 2019/10/22 19:30
 */
public class Main {

    @Resource(name = "patientServiceImpl")
    PatientService patientService;
    @Resource(name = "appointServiceImpl")
    AppointService appointService;
    @Resource(name = "DoctorServiceImpl")
    DoctorService doctorService;

//    public static String dateToWeek(String datetime) {
//
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
//        Calendar cal = Calendar.getInstance();
//        Date date;
//        try {
//            date = f.parse(datetime);
//            cal.setTime(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        //一周的第几天
//        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
//        if (w < 0)
//            w = 0;
//        return weekDays[w];
//    }
//
//    public static String getFetureDate(int past) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
//        Date today = calendar.getTime();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String result = format.format(today);
////        Log.e(null, result);
//        return result;
//    }
//    public static ArrayList<String> test(int intervals ) {
//        ArrayList<String> pastDaysList = new ArrayList<>();
//        ArrayList<String> fetureDaysList = new ArrayList<>();
//        for (int i = 0; i <7; i++) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) +i);
//            Date today = calendar.getTime();
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String result = format.format(today);
//            fetureDaysList.add(result);
//            pastDaysList.add(dateToWeek(result));
//        }
//        return pastDaysList;
//    }
    @Test
    public void test(){


//        doctorinfo doc=doctorService.getDoctor("0001");
//        System.out.println(doc.getDoctorname());

//        patientinfo patientinfo=loginService.Login("111111","123456");
//        System.out.println(patientinfo);
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//        PatientService patientService=ac.getBean("patientServiceImpl", PatientServiceImpl.class);
//
//        AppointService appointService=ac.getBean("appointServiceImpl", AppointServiceImpl.class);
//
//        patientinfo patientinfo=patientService.Login("111111","123456");
//        System.out.println(patientinfo.toString());


//        patientinfo patientinfo1=new patientinfo();
//        patientinfo1.setPatientid("188");
//        patientinfo1.setPassword("111111");
//        boolean boolen=patientService.updatePatient(patientinfo1);
//        System.out.println(boolen);

//        appointinfo appointinfo=new appointinfo("188","101001","2","MonPM");
//
//        appointrecord appointrecord=new appointrecord("201910241","188","20191024","1","MonPM");
//
//        appointService.upappointrecord(appointinfo,appointrecord);
//          appointrecord appointrecord=appointService.select("188");
//        System.out.println(appointrecord);

//        appointService.deappointrecord("188");

    }




}
