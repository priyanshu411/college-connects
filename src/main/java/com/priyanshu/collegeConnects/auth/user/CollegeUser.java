package com.priyanshu.collegeConnects.auth.user;

import org.springframework.security.core.userdetails.User;

public class CollegeUser{
    private String userName;
    private String Password;
    private String userType;

    @Override
    public String toString() {
        return "CollegeUser{" +
                "userName='" + userName + '\'' +
                ", Password='" + Password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    public CollegeUser(String userName, String password, String userType) {
        this.userName = userName;
        this.Password = password;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
