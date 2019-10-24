package com.gm.hosptial.pojo;

public class visitrecord {
    private String patientid;

    private String doctorid;

    private Integer visitstatus;

    private String recipe;

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

    public Integer getVisitstatus() {
        return visitstatus;
    }

    public void setVisitstatus(Integer visitstatus) {
        this.visitstatus = visitstatus;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe == null ? null : recipe.trim();
    }
}