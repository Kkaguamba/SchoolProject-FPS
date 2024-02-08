package com.example.farepaymentsysapp;

public class User {
    private String uName;
    private String phone;
    private String passwd;
    private String confPasswd;

    public User(){

    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getConfPasswd() {
        return confPasswd;
    }

    public void setConfPasswd(String confPasswd) {
        this.confPasswd = confPasswd;
    }


}
