package com.priyanshu.collegeConnects.subjectTopics.api;

import com.priyanshu.collegeConnects.database.entity.SubjectTopics;
import com.priyanshu.collegeConnects.jwt.jwtHelper.JwtUtil;
import com.priyanshu.collegeConnects.response.ApiResponse;
import com.priyanshu.collegeConnects.subjectTopics.dto.SubjectTopicsResponseDto;
import com.priyanshu.collegeConnects.subjectTopics.service.SubjectTopicsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class SubjectTopicsApi {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private SubjectTopicsService subjectTopicsService;
    @PostMapping(value = "/upload/subjectTopic")
    public ApiResponse uploadSubjectTopics(@RequestBody SubjectTopics subjectTopics,@RequestHeader("Authorization") String authorization){
        String jwtToken=authorization.substring(7);
        return subjectTopicsService.uploadSubjectTopics(jwtUtil.extractUsername(jwtToken),subjectTopics);
    }
    @GetMapping(value = "/subjectTopic")
    public List<SubjectTopicsResponseDto> getSubjectTopicNews(@RequestParam("date") String date, @RequestHeader("Authorization") String authorization){
        String jwtToken=authorization.substring(7);
        return subjectTopicsService.getSubjectTopicNews(jwtUtil.extractUsername(jwtToken),date);
    }


}