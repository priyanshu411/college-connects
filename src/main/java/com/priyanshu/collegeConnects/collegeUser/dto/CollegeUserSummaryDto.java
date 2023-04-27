package com.priyanshu.collegeConnects.collegeUser.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@Builder
public class CollegeUserSummaryDto {
    private String enrollmentNo;
    private String userName;
    private String course;
    private String semester;
    private String passOutYear;
    private String userType;
}
