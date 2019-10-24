package com.gm.hosptial.pojo;

public class timetable {
    private Integer tid;

    private String queueno;

    private String queuetimeinfo;

    private String queueamorpm;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getQueueno() {
        return queueno;
    }

    public void setQueueno(String queueno) {
        this.queueno = queueno == null ? null : queueno.trim();
    }

    public String getQueuetimeinfo() {
        return queuetimeinfo;
    }

    public void setQueuetimeinfo(String queuetimeinfo) {
        this.queuetimeinfo = queuetimeinfo == null ? null : queuetimeinfo.trim();
    }

    public String getQueueamorpm() {
        return queueamorpm;
    }

    public void setQueueamorpm(String queueamorpm) {
        this.queueamorpm = queueamorpm == null ? null : queueamorpm.trim();
    }
}