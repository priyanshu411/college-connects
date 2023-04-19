package com.priyanshu.collegeConnects.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="college_user")
public class CollegeUser{
    @Id
    @Column(name="enrollment_no")
    private String enrollmentNo;
    @Column(name="user_name")
    private String userName;
    @Column(name="email")
    private String email;
    @Column(name="contact_no")
    private String contactNo;
    @Column(name="course")
    private String course;
    @Column(name="semester")
    private String semester;
    @Column(name="pass_out_year")
    private String passOutYear;
    @Column(name="password")
    private String password;
    @Column(name="user_role")
    private String userType;

    @Override
    public String toString() {
        return "CollegeUser{" +
                "userName='" + userName + '\'' +
                ", Password='" + password + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    public CollegeUser() {
    }

    public CollegeUser(String userName, String password, String userType) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }


//    getter and setter

    public String getEnrollmentNo() {
        return enrollmentNo;
    }

    public void setEnrollmentNo(String enrollmentNo) {
        this.enrollmentNo = enrollmentNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getPassOutYear() {
        return passOutYear;
    }

    public void setPassOutYear(String passOutYear) {
        this.passOutYear = passOutYear;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
