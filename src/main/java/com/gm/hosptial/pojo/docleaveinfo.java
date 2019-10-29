package com.gm.hosptial.pojo;

public class docleaveinfo {

    private String doctorid;

    private Integer flag;

    private Integer leastatime;

    private Integer leadaynum;

    private Integer timestatus;

    private String tbdoctorid;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid == null ? null : doctorid.trim();
    }

    public Integer getLeastatime() {
        return leastatime;
    }

    public void setLeastatime(Integer leastatime) {
        this.leastatime = leastatime;
    }

    public Integer getLeadaynum() {
        return leadaynum;
    }

    public void setLeadaynum(Integer leadaynum) {
        this.leadaynum = leadaynum;
    }

    public Integer getTimestatus() {
        return timestatus;
    }

    public void setTimestatus(Integer timestatus) {
        this.timestatus = timestatus;
    }

    public String getTbdoctorid() {
        return tbdoctorid;
    }

    public void setTbdoctorid(String tbdoctorid) {
        this.tbdoctorid = tbdoctorid == null ? null : tbdoctorid.trim();
    }
}