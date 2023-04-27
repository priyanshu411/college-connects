package com.priyanshu.collegeConnects.collegeUser.api;

import com.priyanshu.collegeConnects.collegeUser.dto.CollegeUserSummaryDto;
import com.priyanshu.collegeConnects.collegeUser.service.CollegeUserService;
import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import com.priyanshu.collegeConnects.jwt.jwtHelper.JwtUtil;
import com.priyanshu.collegeConnects.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CollegeUserApi {
@Autowired
    private CollegeUserService collegeUserService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping(value = "/user/create")
    public ApiResponse CreateCollegeUser(@RequestBody CollegeUser collegeUser){
        return collegeUserService.createCollegeUser(collegeUser);
    }

    @GetMapping(value = "/user")
    public CollegeUserSummaryDto getUser(@RequestHeader("Authorization") String authorization){
        String jwtToken=authorization.substring(7);
        return collegeUserService.getUserSummary(jwtUtil.extractUsername(jwtToken));

    }
}
