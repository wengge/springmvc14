package com.newer.bean;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.Serializable;

public class User implements Serializable{

    private Integer userId;
    private String username;
    private String pwd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
