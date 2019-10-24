package com.gm.hosptial.pojo;

public class idinfo {
    private String id;

    public idinfo() {
    }

    private String name;

    public idinfo(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}