package com.gm.hosptial.pojo;

public class appoint {
    private String patientid;

    private String doctorid;

    private String hao;

    private String number;

    private String appointnumber;

    private String appointtime;

    private String appointstatus;

    public appoint(String patientid, String doctorid, String hao, String number, String appointnumber, String appointtime, String appointstatus) {
        this.patientid = patientid;
        this.doctorid = doctorid;
        this.hao = hao;
        this.number = number;
        this.appointnumber = appointnumber;
        this.appointtime = appointtime;
        this.appointstatus = appointstatus;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getHao() {
        return hao;
    }

    public void setHao(String hao) {
        this.hao = hao;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAppointnumber() {
        return appointnumber;
    }

    public void setAppointnumber(String appointnumber) {
        this.appointnumber = appointnumber;
    }

    public String getAppointtime() {
        return appointtime;
    }

    public void setAppointtime(String appointtime) {
        this.appointtime = appointtime;
    }

    public String getAppointstatus() {
        return appointstatus;
    }

    public void setAppointstatus(String appointstatus) {
        this.appointstatus = appointstatus;
    }
}
