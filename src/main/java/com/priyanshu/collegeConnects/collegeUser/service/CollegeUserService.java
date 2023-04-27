package com.priyanshu.collegeConnects.collegeUser.service;

import com.priyanshu.collegeConnects.collegeUser.dto.CollegeUserSummaryDto;
import com.priyanshu.collegeConnects.database.entity.CollegeUser;
import com.priyanshu.collegeConnects.database.repository.ICollegeUser;
import com.priyanshu.collegeConnects.exception.UserAlreadyPresentException;
import com.priyanshu.collegeConnects.exception.UserNotFoundException;
import com.priyanshu.collegeConnects.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollegeUserService {
    @Autowired
    private ICollegeUser repository;


    public ApiResponse createCollegeUser(CollegeUser user){
        if(repository.findById(user.getEnrollmentNo()).isPresent() ||repository.findByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyPresentException(user.getEnrollmentNo(),"User already present with this enrollment No or email");
        }
        repository.save(user);
        return new ApiResponse(user.getEnrollmentNo(),"Success","Account created successfully");
    }
    public Optional<CollegeUser> getUser(String enrollmentNo){
        Optional<CollegeUser> user=repository.findById(enrollmentNo);
        return user;

    }
    public CollegeUserSummaryDto getUserSummary(String enrollmentNo ){
        Optional<CollegeUser> user=repository.findById(enrollmentNo);
        if(user.isPresent()){
            CollegeUserSummaryDto collegeUserSummaryDto=CollegeUserSummaryDto.builder()
                    .enrollmentNo(user.get().getEnrollmentNo())
                    .userName(user.get().getUserName())
                    .course(user.get().getCourse())
                    .semester(user.get().getSemester())
                    .userType(user.get().getUserType())
                    .passOutYear(user.get().getPassOutYear())
                    .build();
            return collegeUserSummaryDto;
        }else{
            throw new UserNotFoundException(enrollmentNo,"user not found");
        }

    }
}
