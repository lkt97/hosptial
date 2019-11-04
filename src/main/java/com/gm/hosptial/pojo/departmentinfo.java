package com.gm.hosptial.pojo;

public class departmentinfo {
    private String departmentid;

    private String departmentname;

    private String departmentintroduction;

    private String doctornum;

    public String getDoctornum() {
        return doctornum;
    }

    public void setDoctornum(String doctornum) {
        this.doctornum = doctornum;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }


    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public String getDepartmentintroduction() {
        return departmentintroduction;
    }

    public void setDepartmentintroduction(String departmentintroduction) {
        this.departmentintroduction = departmentintroduction == null ? null : departmentintroduction.trim();
    }
}