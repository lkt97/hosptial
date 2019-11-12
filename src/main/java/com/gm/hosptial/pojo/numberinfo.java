package com.gm.hosptial.pojo;

public class numberinfo {
    private Integer tid;
    private String doctorid;

    private String number;

    private Integer sumnumber;

    @Override
    public String toString() {
        return "numberinfo{" +
                "doctorid='" + doctorid + '\'' +
                ", number='" + number + '\'' +
                ", sumnumber=" + sumnumber +
                '}';
    }

    public numberinfo() {
    }

    public numberinfo( String doctorid, String number, Integer sumnumber) {
        this.doctorid = doctorid;
        this.number = number;
        this.sumnumber = sumnumber;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

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