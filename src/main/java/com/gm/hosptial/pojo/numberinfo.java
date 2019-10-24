package com.gm.hosptial.pojo;

public class numberinfo {
    private String doctorid;

    private String number;

    private Integer sumnumber;

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid == null ? null : doctorid.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getSumnumber() {
        return sumnumber;
    }

    public void setSumnumber(Integer sumnumber) {
        this.sumnumber = sumnumber;
    }
}