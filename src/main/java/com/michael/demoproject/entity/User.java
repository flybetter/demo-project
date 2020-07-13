package com.michael.demoproject.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String userName;
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
