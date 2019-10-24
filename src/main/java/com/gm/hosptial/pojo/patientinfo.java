package com.gm.hosptial.pojo;

public class patientinfo {
    private String patientid;//患者编号

    private String patientname;//患者名称

    private String patientphone;//患者联系方式

    private String patientsex;//患者性别

    private Integer patientstatus;//预约状态

    private String id;//身份证号码

    private String password;//患者登录密码

    private Integer freezetime;//解冻时间

    public patientinfo() {
    }

    public patientinfo(String patientid, String patientname, String patientphone, String patientsex,
                        String id, String password) {
        this.patientid = patientid;

        this.patientname = patientname;
        this.patientphone = patientphone;
        this.patientsex = patientsex;

        this.id = id;
        this.password = password;

    }
    public patientinfo(String patientid, String patientname, String patientphone, String patientsex,
                       Integer patientstatus, String id, String password) {
        this.patientid = patientid;

        this.patientname = patientname;
        this.patientphone = patientphone;
        this.patientsex = patientsex;
        this.patientstatus = patientstatus;
        this.id = id;
        this.password = password;

    }

    @Override
    public String toString() {
        return "patientinfo{" +
                "patientid='" + patientid + '\'' +

                ", patientname='" + patientname + '\'' +
                ", patientphone='" + patientphone + '\'' +
                ", patientsex='" + patientsex + '\'' +
                ", patientstatus=" + patientstatus +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", freezetime=" + freezetime +
                '}';
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid == null ? null : patientid.trim();
    }


    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname == null ? null : patientname.trim();
    }

    public String getPatientphone() {
        return patientphone;
    }

    public void setPatientphone(String patientphone) {
        this.patientphone = patientphone == null ? null : patientphone.trim();
    }

    public String getPatientsex() {
        return patientsex;
    }

    public void setPatientsex(String patientsex) {
        this.patientsex = patientsex == null ? null : patientsex.trim();
    }

    public Integer getPatientstatus() {
        return patientstatus;
    }

    public void setPatientstatus(Integer patientstatus) {
        this.patientstatus = patientstatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getFreezetime() {
        return freezetime;
    }

    public void setFreezetime(Integer freezetime) {
        this.freezetime = freezetime;
    }
}