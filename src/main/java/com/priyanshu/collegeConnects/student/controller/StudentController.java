package com.priyanshu.collegeConnects.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {
        @GetMapping("/student")
        public  String getStudents(){
            System.out.println("\nthis is student get api\n");
            return  "this is student get api";
        }
    }
