package com.gm.hosptial.pojo;

public class scheduleinfo {
    private String doctorid;

    private String departmentname;

    private Integer sunam;

    private Integer monam;

    private Integer tueam;

    private Integer wedam;

    private Integer thuram;

    private Integer friam;

    private Integer satam;

    private Integer sunpm;

    private Integer monpm;

    private Integer tuepm;

    private Integer wedpm;

    private Integer thurpm;

    private Integer fripm;

    private Integer satpm;

    public scheduleinfo() {
    }

    public scheduleinfo(String doctorid, String departmentname, Integer sunam, Integer monam, Integer tueam, Integer wedam, Integer thuram, Integer friam, Integer satam, Integer sunpm, Integer monpm, Integer tuepm, Integer wedpm, Integer thurpm, Integer fripm, Integer satpm) {
        this.doctorid = doctorid;
        this.departmentname = departmentname;
        this.sunam = sunam;
        this.monam = monam;
        this.tueam = tueam;
        this.wedam = wedam;
        this.thuram = thuram;
        this.friam = friam;
        this.satam = satam;
        this.sunpm = sunpm;
        this.monpm = monpm;
        this.tuepm = tuepm;
        this.wedpm = wedpm;
        this.thurpm = thurpm;
        this.fripm = fripm;
        this.satpm = satpm;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid == null ? null : doctorid.trim();
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }


    public Integer getSunam() {
        return sunam;
    }

    public void setSunam(Integer sunam) {
        this.sunam = sunam;
    }

    public Integer getMonam() {
        return monam;
    }

    public void setMonam(Integer monam) {
        this.monam = monam;
    }

    public Integer getTueam() {
        return tueam;
    }

    public void setTueam(Integer tueam) {
        this.tueam = tueam;
    }

    public Integer getWedam() {
        return wedam;
    }

    public void setWedam(Integer wedam) {
        this.wedam = wedam;
    }

    public Integer getThuram() {
        return thuram;
    }

    public void setThuram(Integer thuram) {
        this.thuram = thuram;
    }

    public Integer getFriam() {
        return friam;
    }

    public void setFriam(Integer friam) {
        this.friam = friam;
    }

    public Integer getSatam() {
        return satam;
    }

    public void setSatam(Integer satam) {
        this.satam = satam;
    }

    public Integer getSunpm() {
        return sunpm;
    }

    public void setSunpm(Integer sunpm) {
        this.sunpm = sunpm;
    }

    public Integer getMonpm() {
        return monpm;
    }

    public void setMonpm(Integer monpm) {
        this.monpm = monpm;
    }

    public Integer getTuepm() {
        return tuepm;
    }

    public void setTuepm(Integer tuepm) {
        this.tuepm = tuepm;
    }

    public Integer getWedpm() {
        return wedpm;
    }

    public void setWedpm(Integer wedpm) {
        this.wedpm = wedpm;
    }

    public Integer getThurpm() {
        return thurpm;
    }

    public void setThurpm(Integer thurpm) {
        this.thurpm = thurpm;
    }

    public Integer getFripm() {
        return fripm;
    }

    public void setFripm(Integer fripm) {
        this.fripm = fripm;
    }

    public Integer getSatpm() {
        return satpm;
    }

    public void setSatpm(Integer satpm) {
        this.satpm = satpm;
    }
}