package com.gm.hosptial.pojo;

public class visitrecord {
    private String patientid;

    private String doctorid;

    private String visitstatus;

    private String recipe;

    private String AppointNumber;

    public String getAppointNumber() {
        return AppointNumber;
    }

    public void setAppointNumber(String appointNumber) {
        AppointNumber = appointNumber;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid == null ? null : patientid.trim();
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid == null ? null : doctorid.trim();
    }

    public String getVisitstatus() {
        return visitstatus;
    }

    public void setVisitstatus(String visitstatus) {
        this.visitstatus = visitstatus;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe == null ? null : recipe.trim();
    }
}