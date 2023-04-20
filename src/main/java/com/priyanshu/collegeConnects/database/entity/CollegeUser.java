package com.priyanshu.collegeConnects.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="college_user")
@Getter
@Setter
@ToString
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
}
