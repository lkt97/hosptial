package com.gm.hosptial.pojo;

public class doctorinfo {
    private String doctorid;

    private String doctorname;

    private String doctorphone;

    private String doctordeptid;

    private Integer doctorstatus;

    private String doctorspecialty;

    private String doctorjobtitle;

    private String docpassword;

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid == null ? null : doctorid.trim();
    }


    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname == null ? null : doctorname.trim();
    }

    public String getDoctorphone() {
        return doctorphone;
    }

    public void setDoctorphone(String doctorphone) {
        this.doctorphone = doctorphone == null ? null : doctorphone.trim();
    }

    public String getDoctordeptid() {
        return doctordeptid;
    }

    public void setDoctordeptid(String doctordeptid) {
        this.doctordeptid = doctordeptid == null ? null : doctordeptid.trim();
    }

    public Integer getDoctorstatus() {
        return doctorstatus;
    }

    public void setDoctorstatus(Integer doctorstatus) {
        this.doctorstatus = doctorstatus;
    }

    public String getDoctorspecialty() {
        return doctorspecialty;
    }

    public void setDoctorspecialty(String doctorspecialty) {
        this.doctorspecialty = doctorspecialty == null ? null : doctorspecialty.trim();
    }

    public String getDoctorjobtitle() {
        return doctorjobtitle;
    }

    public void setDoctorjobtitle(String doctorjobtitle) {
        this.doctorjobtitle = doctorjobtitle == null ? null : doctorjobtitle.trim();
    }

    public String getDocpassword() {
        return docpassword;
    }

    public void setDocpassword(String docpassword) {
        this.docpassword = docpassword == null ? null : docpassword.trim();
    }
}