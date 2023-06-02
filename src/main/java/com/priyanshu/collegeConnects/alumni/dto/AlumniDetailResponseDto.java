package com.priyanshu.collegeConnects.alumni.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlumniDetailResponseDto {
    private String userName;
    private String email;
    private String contactNo;
    private String course;
    private String company;
    private String resume;
    private String linkedIn;
    private String github;
    private String portfolio;
}
