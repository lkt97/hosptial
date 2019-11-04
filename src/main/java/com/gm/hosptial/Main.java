package com.gm.hosptial;

import com.gm.hosptial.mapper.LoginMapper;
import com.gm.hosptial.mapper.patientinfoMapper;
import com.gm.hosptial.pojo.appointinfo;
import com.gm.hosptial.pojo.appointrecord;
import com.gm.hosptial.pojo.doctorinfo;
import com.gm.hosptial.pojo.patientinfo;

import com.gm.hosptial.service.AppointService;
import com.gm.hosptial.service.DoctorService;
import com.gm.hosptial.service.PatientService;

import com.gm.hosptial.service.impl.AppointServiceImpl;
import com.gm.hosptial.service.impl.PatientServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

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

    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
//        Log.e(null, result);
        return result;
    }
    public static ArrayList<String> test(int intervals ) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        ArrayList<String> fetureDaysList = new ArrayList<>();
        for (int i = 0; i <7; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) +i);
            Date today = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String result = format.format(today);
            fetureDaysList.add(result);
            pastDaysList.add(dateToWeek(result));
        }
        return pastDaysList;
    }
    @Test
    public void test(){
        test(7);

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



//
//
//    public static void main(String[] args) throws IOException {
//
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//        LoginService loginService=applicationContext.getBean("loginService",LoginServiceImpl.class);
////        System.out.println(loginService);
////
//        //1.定义mybatis的命名空间
////        String resources = "SqlMapConfig.xml";
////        //2.获取SqlSessionFactory构建者
////        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////        InputStream is = Resources.getResourceAsStream(resources);
////        //3.获取SqlSession工厂
////        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
////        //4.获取sqlSession
////        SqlSession sqlSession = sessionFactory.openSession();
////        LoginMapper loginMapper=sqlSession.getMapper(LoginMapper.class);
////        HashMap<String, Object> map = new HashMap<>();
////        map.put("patientid",111111);
////        map.put("password",123456);
////        System.out.println(map);
////        loginMapper.login(map);
////        System.out.println(loginMapper.login(map).getTid());
//
//
//
//
////        patientinfo patientinfo=loginService.Login("111111","123456");
////        System.out.println(patientinfo);
//
////        patientinfoMapper patientinfoMapper =sqlSession.getMapper(patientinfoMapper.class);
////        patientinfoMapper.selectByPrimaryKey("111111");
//        patientinfo patientinfo=loginService.Login("111111","123456");
//        System.out.println(patientinfo);
//    }

}
