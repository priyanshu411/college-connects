package com.priyanshu.collegeConnects.collegeUser.api;

import com.priyanshu.collegeConnects.collegeUser.service.CollegeUserService;
import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CollegeUserApi {
@Autowired
    private CollegeUserService collegeUserService;
    @PostMapping(value = "user/create")
    public CollegeUser CreateCollegeUser(@RequestBody CollegeUser collegeUser){
        return collegeUserService.createCollegeUser(collegeUser);
    }
}
