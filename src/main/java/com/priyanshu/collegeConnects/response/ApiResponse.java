package com.priyanshu.collegeConnects.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
    private String id;
    private String status;
    private String message;
}
