package com.priyanshu.collegeConnects.alumni.api;

import com.priyanshu.collegeConnects.alumni.dto.AlumniDetailResponseDto;
import com.priyanshu.collegeConnects.alumni.service.AlumniService;
import com.priyanshu.collegeConnects.database.entity.AlumniDetail;
import com.priyanshu.collegeConnects.jwt.jwtHelper.JwtUtil;
import com.priyanshu.collegeConnects.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AluminiApi {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AlumniService alumniService;
    @PostMapping("/addAlumni")
    public ApiResponse addAlumni(@RequestBody AlumniDetail alumniDetail, @RequestHeader("Authorization") String authorization){
        String jwtToken=authorization.substring(7);
        return alumniService.addAlumni(alumniDetail,jwtUtil.extractUsername(jwtToken));
    }

    @GetMapping("/alumni")
    public List<AlumniDetailResponseDto> addAlumni(@Param("userName") String userName){
        return alumniService.searchAlumni(userName);
    }
}
